/**
 * Copyright 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import { Component, OnDestroy, OnInit } from '@angular/core';
import { DeviceService } from '../shared/device/device.service';
import { GiphyService } from '../shared/giphy/giphy.service';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { getDeviceIcon } from '../device.icon';

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})
export class DeviceListComponent implements OnInit, OnDestroy {
  devices: Array<any>;
  sub: Subscription;
  debugRequest: string;
  debugResponse: string;
  debugDelta: string;
  file;
  id;
  constructor(private route: ActivatedRoute,
    private router: Router, private deviceService: DeviceService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.file = params['file'];
      this.id = params['id'];
      this.changeRefreshState(false);
      console.log('calling backend with ' + this.id);
      if (this.id) {
        this.deviceService.getAll(this.file, this.id).subscribe(data => {
          this.changeRefreshState(true);
          this.devices = data;
          console.log('Data response', data);
          for (const device of this.devices) {
            device.state = Object.entries(device.statesCache).map(([k, v]) => {
              return `${k}: ${JSON.stringify(v)}`
            })
            const giphyService = this.giphyService.get(device.name);
            if (giphyService) {
              giphyService.subscribe(url => {
                device.giphyUrl = url;
              });
            } else {
              device.icon = getDeviceIcon(device.type);
            }
          }
        });
      }
    });
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  refresh() {
    if (this.id) {
      this.changeRefreshState(false);
      this.deviceService.refresh(this.id).subscribe(data => {
        this.changeRefreshState(true);
        this.devices = data.devices;
        this.debugRequest = data.debugRequest;
        this.debugResponse = data.debugResponse;
        this.debugDelta = data.debugDelta;
        console.log('Data response', data);
        for (const device of this.devices) {
          device.state = Object.entries(device.statesCache).map(([k, v]) => {
            return `${k}: ${JSON.stringify(v)}`
          })
          const giphyService = this.giphyService.get(device.name);
          if (giphyService) {
            giphyService.subscribe(url => {
              device.giphyUrl = url;
            });
          } else {
            device.icon = getDeviceIcon(device.type);
          }
        }
      });
    }
  }
  changeRefreshState(enable) {
    const refreshButton: HTMLButtonElement = <HTMLButtonElement>document.querySelector('button.mat-fab');
    refreshButton.innerHTML = enable ? 'Refresh' : '...';
    refreshButton.disabled = !enable;
  }
}

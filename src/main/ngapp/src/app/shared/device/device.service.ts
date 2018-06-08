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
import { environment } from '../../../environments/environment';
import { getBaseLocation } from '../common-functions.util';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DeviceService {

  public DEVICE_API = environment.API + '/devices';

  constructor(private http: HttpClient) {
  }

  getAll(file: string, id: string): Observable<any> {
    return this.http.get(getBaseLocation() + '/homegraph?agentUserId=' + id + '&file=' + file);
  }

  refresh(id: string): Observable<any> {
    return this.http.get(getBaseLocation() + '/refresh?agentUserId=' + id);
  }


}

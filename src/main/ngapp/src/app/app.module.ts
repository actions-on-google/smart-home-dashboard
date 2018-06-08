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
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DeviceService } from './shared/device/device.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { DeviceListComponent } from './device-list/device-list.component';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatExpansionModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GiphyService } from './shared/giphy/giphy.service';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { UploadFileService } from './shared/upload/upload-file.service';

import { APP_BASE_HREF, Location } from '@angular/common';
import { getBaseLocation } from './shared/common-functions.util';

const appRoutes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'device-list/:file/:id',
    component: DeviceListComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    DeviceListComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatExpansionModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [DeviceService, UploadFileService, GiphyService, {
    provide: APP_BASE_HREF,
    useFactory: getBaseLocation
  }, ],
  bootstrap: [AppComponent]
})
export class AppModule { }

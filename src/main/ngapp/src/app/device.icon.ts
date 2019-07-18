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

const deviceIconMap = {
  'AC_UNIT': 'ac_unit',
  'AIRFRESHENER': 'hourglass_full',
  'AIRPURIFIER': 'sim_card',
  'AWNING': 'store_mall_directory',
  'BLINDS': 'view_week',
  'BOILER': 'invert_colors',
  'CAMERA': 'camera_alt',
  'COFFEEMAKER': 'local_cafe',
  'CURTAIN': 'flag',
  'DISHWASHER': 'restaurant',
  'DOOR': 'open_in_new',
  'DRYER': 'casino',
  'FAN': 'toys',
  'FIREPLACE': 'whatshot',
  'GARAGEDOOR': 'drive_eta',
  'GATE': 'storage',
  'HEATER': 'account_balance_wallet',
  'HOOD': 'view_day',
  'KETTLE': 'filter_frames',
  'LIGHT': 'wb_incandescent',
  'LOCK': 'lock',
  'MICROWAVE': 'nfc',
  'OUTLET': 'power',
  'OVEN': 'web',
  'PERGOLA': 'layers',
  'REFRIGERATOR': 'kitchen',
  'SCENE': 'slideshow',
  'SECURITYSYSTEM': 'verified_user',
  'SHOWER': 'local_car_wash',
  'SHUTTER': 'map',
  'SPRINKLER': 'filter_vintage',
  'SWITCH': 'call_merge',
  'THERMOSTAT': 'brightness_7',
  'VACUUM': 'router',
  'VALVE': 'settings_input_component',
  'WASHER': 'local_laundry_service',
  'WATERHEATER': 'local_drink',
  'WINDOW': 'wallpaper'
}

/**
 * Wrap the icon name in an HTML element to display
 * 
 * @param deviceType The full namespace of the device type
 * @returns The HTML element that will show that icon
 */
export const getDeviceIcon = (deviceType: string) => {
  return deviceIconMap[deviceType] || 'code' /* `code` is default icon */;
}
# StripedProcessButton
HarmonyOS library. Animated striped button to show loading process.

## Screenshot
<img src = "https://github.com/alpesh12345/StripedProcessButton/blob/main/screenshots/stripedprocessbutton.gif"/>

## Usage

Adjust the xml view
```
<com.alpesh.strippedprocessbutton.StripedProcessButton
        ohos:id="$+id:btn_start"
        ohos:left_margin="16fp"
        ohos:right_margin="16fp"
        ohos:width="match_parent"
        ohos:height="60fp"
        ohos:layout_alignment="center"
        ohos:top_margin="40fp"
        ohos:text_size="20fp"
        ohos:text="StartProcess"
        ohos:text_font="sans-serif"
        ohos:text_weight="700"
        app:spb_showStripes="false"
        app:spb_loadingText="Buffer..."
        app:spb_cornerRadius="25"
        ohos:clickable="true"
        ohos:focusable="focus_enable"
        ohos:text_color="#FFF1F1F0"
        />
```
Adjust programmatically (shortly):
```
stripedButton.setCornerRadius(50)
        .setStripeAlpha(0.7f)
        .setStripeRevert(true)
        .setStripeGradient(false)
        .setTilt(15)
        .start();
```
## License
Copyright 2018 Ivan Vodyasov

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
```
http://www.apache.org/licenses/LICENSE-2.0
```
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

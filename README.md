# StripedProcessButton
It's an HarmonyOS library.<br> 
This provides an Animated striped button to show the loading process.

## Source
Inspired by https://github.com/nikartm/StripedProcessButton Version v2.0.0

## Screenshot
<img src = "https://github.com/alpesh12345/StripedProcessButton/blob/main/screenshots/stripedprocessbutton.gif"/>

## Features
It provides an animated striped button that appears to be normal(on you to show or hide strips) but when clicked it gets animated according to attributes to show the loading process. 
* Different colors can be set to show when normal and other strip colors to animate strips when clicked. 
* Here you get the option to use GradientShader or just a normal shader (spb_stripeGradient is used to set it). <br> 
Can observe both buttons clicked in the gif are set to true for stripe gradient and others are using a normal linear shader. 
* You can set text that needs to be displayed while the loading process is showing and normal button text will be displayed when stop.
* This text gets drawn above the animating button. Also actual button text is changed internally so that if match content is used, you can see required results. 
* You can set corner radius for button and the button will get rounded corner accordingly. 
* No need to use the different graphic file for a button background, all features about setting the background color to corner radius are included over here. 
* This provides the option to you about how much to tilt the strip while animating. Also, you can revert the strips. 
* Strip width can also be set according to requirement. 
* All functionality can be adjusted programmatically also, example is shown in Usage. 
* All functionality of normal button is retained and same font attributes will be used to display text while the button is animated. 
* This can be used as a normal button also and can get the benefit of all features in one place.
## Installation Instructions
1.For using StripedProcessButton module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```
	dependencies {
		implementation project(':support')
        implementation fileTree(dir: 'libs', include: ['*.har'])
        testCompile 'junit:junit:4.12'
	}
```
2.For using StripedProcessButton in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```
	dependencies {
		implementation fileTree(dir: 'libs', include: ['*.har'])
		testCompile 'junit:junit:4.12'
	}
```
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
## Future work
Circular Reveal animation for button feature is currently not supported. One's platform includes this, it can be integrated here.
## License
Copyright 2018 Ivan Vodyasov

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
```
http://www.apache.org/licenses/LICENSE-2.0
```
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

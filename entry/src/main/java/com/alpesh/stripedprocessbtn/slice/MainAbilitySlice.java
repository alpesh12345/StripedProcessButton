package com.alpesh.stripedprocessbtn.slice;

import com.alpesh.stripedprocessbtn.ResourceTable;
import com.alpesh.strippedprocessbutton.StripedProcessButton;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.utils.Color;

public class MainAbilitySlice extends AbilitySlice {

    private StripedProcessButton stripedButton;
    private Button btnStop;
    private StripedProcessButton btn_2;
    private StripedProcessButton btn_3;
    private StripedProcessButton btn_4;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        stripedButton = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_start);
        btnStop = (Button) findComponentById(ResourceTable.Id_btn_stop);
        btn_2 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_2);
        btn_3 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_3);
        btn_4 = (StripedProcessButton) findComponentById(ResourceTable.Id_btn_4);
        btn_3.start();
        btn_4.start();
        //initStripedButton();
        stripedButton.setClickedListener(v -> stripedButton.start());
        btn_2.setClickedListener(v -> btn_2.start());
        btnStop.setClickedListener(component -> {
            stripedButton.stop();
            btn_2.stop();
        });
    }

    /*private void initStripedButton() {
        stripedButton.setStripeAlpha(0.7f)
                .setStripeRevert(true)
                .setStripeGradient(false)
                .setTilt(15)
                .setColorMain(Color.GREEN.getValue())
                .setColorBack(Color.YELLOW.getValue())
                .start();
    }*/

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}

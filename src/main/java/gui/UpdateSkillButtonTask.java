package gui;

import controller.FileManager;
import model.Skill;
import model.WeaponSet;
import org.jetbrains.annotations.Nullable;
import util.methodsUtil;
import view.SkillPopUp;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class UpdateSkillButtonTask implements Runnable {
    private final List<JButton> slotButtons;
    private final int buttonIndex;
    private final String professionName;
    private final String attunement;
    private final WeaponSet weaponSet;
    private final boolean isDualWield;
    private final String weaponSlot;
    private Popup popup;

    public UpdateSkillButtonTask(List<JButton> slotButtons, int buttonIndex, String professionName, @Nullable String attunement, WeaponSet weaponSet, boolean isDualWield, String weaponSlot) {
        this.slotButtons = slotButtons;
        this.buttonIndex = buttonIndex;
        this.professionName = professionName;
        this.attunement = attunement;
        this.weaponSet = weaponSet;
        this.isDualWield = isDualWield;
        this.weaponSlot = weaponSlot;
    }

    @Override
    public void run() {
        try {
            List<Skill> slotSkills;
            if (isDualWield) {
                if (buttonIndex <= 2) {
                    slotSkills = FileManager.getInstance().getSkillsFor(professionName, weaponSet.getWeaponTypeSet()[0], weaponSlot, attunement);
                } else {
                    slotSkills = FileManager.getInstance().getSkillsFor(professionName, weaponSet.getWeaponTypeSet()[1], weaponSlot, attunement);
                }
            } else {
                slotSkills = FileManager.getInstance().getSkillsFor(professionName, weaponSet.getWeaponTypeSet()[0], weaponSlot, attunement);
            }
            for (int i = 0; i < slotSkills.size(); i++) {
                slotButtons.get(i).setIcon(methodsUtil.getIconFromUrl(slotSkills.get(i).icon));
                SkillPopUp skillPopUp = new SkillPopUp();
                skillPopUp.getSkillNameLabel().setText(slotSkills.get(i).name);
                skillPopUp.getDescriptionTextArea().setText(slotSkills.get(i).description);
                JPanel panel = skillPopUp.getPopWindow();
                slotButtons.get(i).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        popup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), panel, e.getXOnScreen() + 25, e.getYOnScreen() + 25);
                        if (popup != null) {
                            popup.show();
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if (popup != null) {
                            popup.hide();
                        }
                    }
                });
            }
            if (slotSkills.size() == 1) {
                slotButtons.get(1).setVisible(false);
                slotButtons.get(2).setVisible(false);
                slotButtons.get(3).setVisible(false);
                slotButtons.get(4).setVisible(false);
            }
            if (slotSkills.size() == 2) {
                slotButtons.get(1).setVisible(true);
            }
            if (slotSkills.size() == 3) {
                slotButtons.get(1).setVisible(true);
                slotButtons.get(2).setVisible(true);
            }
            if (slotSkills.size() == 4) {
                slotButtons.get(1).setVisible(true);
                slotButtons.get(2).setVisible(true);
                slotButtons.get(3).setVisible(true);
            }
            if (slotSkills.size() == 5) {
                slotButtons.get(1).setVisible(true);
                slotButtons.get(2).setVisible(true);
                slotButtons.get(3).setVisible(true);
                slotButtons.get(4).setVisible(true);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
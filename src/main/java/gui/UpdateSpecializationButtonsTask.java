package gui;

import controller.FileManager;
import model.Trait;
import util.methodsUtil;
import view.SkillPopUp;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateSpecializationButtonsTask implements Runnable {

    private final List<JButton> specializationButtons;
    private final String professionName;
    private final String specializationName;
    private Popup popup;

    public UpdateSpecializationButtonsTask(List<JButton> specializationButtons, String professionName, String specializationName) {
        this.specializationButtons = specializationButtons;
        this.professionName = professionName;
        this.specializationName = specializationName;
    }

    @Override
    public void run() {
        try {
            ArrayList<Trait> traits = new ArrayList<>();
            traits.addAll(FileManager.getInstance().getTraitsForProfessionWithSpecialization(
                    professionName, specializationName, 1, "Minor"
            ));
            traits.addAll(FileManager.getInstance().getTraitsForProfessionWithSpecialization(
                    professionName, specializationName, 1, "Major"
            ));
            traits.addAll(FileManager.getInstance().getTraitsForProfessionWithSpecialization(
                    professionName, specializationName, 2, "Minor"
            ));
            traits.addAll(FileManager.getInstance().getTraitsForProfessionWithSpecialization(
                    professionName, specializationName, 2, "Major"
            ));
            traits.addAll(FileManager.getInstance().getTraitsForProfessionWithSpecialization(
                    professionName, specializationName, 3, "Minor"
            ));
            traits.addAll(FileManager.getInstance().getTraitsForProfessionWithSpecialization(
                    professionName, specializationName, 3, "Major"
            ));
            for (int i = 0; i < traits.size(); i++) {
                specializationButtons.get(i).setIcon(methodsUtil.resizeImageIcon(methodsUtil.getIconFromUrl(traits.get(i).icon), 75, 75));
                SkillPopUp skillPopUp = new SkillPopUp();
                skillPopUp.getSkillNameLabel().setText(traits.get(i).name);
                skillPopUp.getDescriptionTextArea().setText(traits.get(i).description);
                JPanel panel = skillPopUp.getPopWindow();
                specializationButtons.get(i).addMouseListener(new MouseAdapter() {
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

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
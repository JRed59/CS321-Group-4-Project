import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class GUI {


    public Schedule s = new Schedule();
    public restaurantFinder rf = new restaurantFinder();
    private JPanel mainMenu;
    private JButton createOrModifyScheduleButton;
    private JButton findRestaurantButton;
    private JButton exitButton;
    private JPanel topMenu;
    private JPanel scheduleEditor;
    private JPanel restaurantFinder;
    private JButton mainMenuButton;
    private JButton quitProgramButton;
    private JButton quitProgramButton1;
    private JButton mainMenuButton1;
    private JButton createSchedule;
    private JButton clearSchedule;
    private JPanel selector;
    private JPanel topPanel;
    private JTextField cName;

    private JTextField cLocation;
    private JComboBox uBuild;
    private JButton another;
    private JButton complete;
    private JButton stopEditingButton;
    private JComboBox cDay;
    private JComboBox cSTime;
    private JComboBox cETime;
    private JButton findRestaurants;
    private JPanel resSub;
    private JTextArea currentSchedule;
    private JButton findAllOpenRestaurantsButton;
    private JPanel rfDaySelect;
    private JButton cFirm;
    private JButton canC;
    private JComboBox cusTime;
    private JComboBox cusDay;
    private JButton findRestaurantsVisitableBetweenButton;
    private JButton mM;


    public GUI() {


        createOrModifyScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.removeAll();
                mainMenu.add(scheduleEditor);
                mainMenu.repaint();
                mainMenu.revalidate();


            }
        });
        findRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.removeAll();
                mainMenu.add(resSub);
                mainMenu.repaint();
                mainMenu.revalidate();
                currentSchedule.setText(s.viewSchedule());

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.removeAll();
                mainMenu.add(topMenu);
                mainMenu.repaint();
                mainMenu.revalidate();
            }
        });
        quitProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        createSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.removeAll();
                mainMenu.add(topPanel);
                mainMenu.repaint();
                mainMenu.revalidate();


            }
        });
        another.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uahClass d = new uahClass("", "", null, null, "");
                getData(d);
                if (d.startTime.compareTo(d.endTime) > -1) {
                    JOptionPane.showMessageDialog(null, "The end time must be later than the start time");
                } else {
                    s.addToSchedule(d);
                    JOptionPane.showMessageDialog(null, "Class added to schedule \n" + s.viewSchedule());
                }


            }
        });
        stopEditingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.removeAll();
                mainMenu.add(scheduleEditor);
                mainMenu.repaint();
                mainMenu.revalidate();
            }
        });
        complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uahClass d = new uahClass("", "", null, null, "");
                getData(d);
                if (d.startTime.compareTo(d.endTime) > -1) {
                    JOptionPane.showMessageDialog(null, "The end time must be later than the start time");
                } else {
                    s.addToSchedule(d);
                    JOptionPane.showMessageDialog(null, "Class added to schedule \n" + s.viewSchedule());
                }
                mainMenu.removeAll();
                mainMenu.add(scheduleEditor);
                mainMenu.repaint();
                mainMenu.revalidate();
            }

        });
        clearSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.clearSchedule();
                JOptionPane.showMessageDialog(null, "Schedule Cleared");
            }
        });


        uBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        findAllOpenRestaurantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] optio = {"Manual entry", "Use time from schedule"};
                int result = JOptionPane.showOptionDialog(null, "Are you choosing a time from a class or manually inputting one", null, 0, 2, null, optio, optio[0]);
                if (result == 1) {
                    if (s.classSchedule.size() == 0) {
                        JOptionPane.showMessageDialog(null, "You have not created a schedule yet.");
                    } else {
                        ArrayList<Integer> options = new ArrayList<Integer>();

                        for (int i = 0; i < s.classSchedule.size(); i++) {
                            options.add(i + 1);
                        }
                        Integer[] opt = options.toArray(new Integer[0]);

                        int selection = JOptionPane.showOptionDialog(null, "Choose a class by it's number from this list \n" + s.viewSchedule(), "Class remover", 0, s.classSchedule.size(), null, opt, opt[0]);
                        rf.findOpenRestaurants(s.classSchedule.get(selection).endTime, s.classSchedule.get(selection).day);

                        JOptionPane.showMessageDialog(null, rf.viewRestaurants());
                    }

                } else {
                    mainMenu.removeAll();
                    mainMenu.add(rfDaySelect);
                    mainMenu.repaint();
                    mainMenu.revalidate();
                    cFirm.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            uahClass cusD = new uahClass("", "", null, null, "");
                            cRFDat(cusD);
                            rf.findOpenRestaurants(cusD.endTime, cusD.day);
                            JOptionPane.showMessageDialog(null, rf.viewRestaurants());

                        }
                    });
                    canC.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mainMenu.removeAll();
                            mainMenu.add(resSub);
                            mainMenu.repaint();
                            mainMenu.revalidate();
                        }
                    });
                }

            }
        });


        mM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.removeAll();
                mainMenu.add(topMenu);
                mainMenu.repaint();
                mainMenu.revalidate();
            }
        });
        findRestaurantsVisitableBetweenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s.classSchedule.size()==0){
                    JOptionPane.showMessageDialog(null,"You need to have a schedule for this option.");
                }
                else{
                    ArrayList<Integer> options = new ArrayList<Integer>();

                    for (int i = 0; i < s.classSchedule.size(); i++) {
                        options.add(i);
                    }
                    Integer[] opt = options.toArray(new Integer[0]);
                    String[] tOpt = {"Driving", "Walking"};
                    int selection1 = JOptionPane.showOptionDialog(null, "Choose the first class by its number \n" + s.viewSchedule(), "Nearby restaurants, class picker 1", 1, s.classSchedule.size(), null, opt, opt[0]);
                    int selection2 = JOptionPane.showOptionDialog(null, "Now choose the second class using its number \n" + s.viewSchedule(), "Nearby restaurants, class picker 2", 1, s.classSchedule.size(), null, opt, opt[0]);
                    if (DayOfWeek.valueOf(s.classSchedule.get(selection1).day).getValue() == DayOfWeek.valueOf(s.classSchedule.get(selection2).day).getValue()) {
                        int transport = JOptionPane.showOptionDialog(null, "Now choose whether you wish to walk or drive", "Transport method picker", 0, 2, null, tOpt, tOpt[0]);
                        rf.findOpenRestaurants(s.classSchedule.get(selection1).endTime, s.classSchedule.get(selection1).day);
                        String s1acro = rf.getAcr(s.classSchedule.get(selection1).location);
                        String s2acro = rf.getAcr(s.classSchedule.get(selection2).location);
                        String closestRes = rf.closestRestaurants(rf.openRestaurantAcronyms, rf.openRestaurants, s1acro, s.classSchedule.get(selection1).endTime, s.classSchedule.get(selection2).startTime, transport, s2acro);
                        JOptionPane.showMessageDialog(null, closestRes);
                    } else {
                        JOptionPane.showMessageDialog(null, "These classes are on different days");
                    }
                }
            }
        });
    }

    public static void GUIMain() {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().mainMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    public void getData(uahClass data) {
        data.setName(cName.getText());
        data.setStartTime(LocalTime.parse(String.valueOf(cSTime.getSelectedItem())));
        data.setEndTime(LocalTime.parse(String.valueOf(cETime.getSelectedItem())));
        data.setLocation(String.valueOf(uBuild.getSelectedItem()));
        data.setDay((String.valueOf(cDay.getSelectedItem())).toUpperCase());
    }

    public void cRFDat(uahClass data) {
        data.setEndTime(LocalTime.parse(String.valueOf(cusTime.getSelectedItem())));
        data.setDay((String.valueOf(cusDay.getSelectedItem()).toUpperCase()));
    }


}





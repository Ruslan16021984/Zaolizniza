package com.gmail.carbit3333333;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;

public class ControllerFrame {
    private StringBuilder builder;
    private String text = "";

    private Box mainBox;

    private MyBox firstBox;
    private MyBox secondBox;
    private MyBox thirddBox;
    private MyBox fourdBox;

    private MyCheckBox teaCheckBox;
    private MyCheckBox bedCheckBox;

    private MyComboBox myComboSityFrom;
    private MyComboBox myComboSityTo;

    private MyJRadioButton manRadioButton;
    private MyJRadioButton womenRadioButton;

    private MyButtonGroup myButtonGroup;

    private MyButton myButton;
    private MyButton btnOk;
    private MyButton btnCancel;
    private MyTextField myTextField;

    private JLabel fromTextField;
    private JLabel toTextField;
    private JLabel teaTextLabel;
    private JLabel bedTextLabel;

    private JLabel fromJLabel;
    private JLabel toLabel;
    private JLabel cenvLabel;
    private JLabel payLabel;

    private String[] aarays = {"Винница", "Днепр", "Донецк", "Житомир", "Запорожье",
            "Ивано-Франковск", "Киев", "Кропивницкий", "Луганск", "Луцк", "Львов",
            "Николаев", "Одесса", "Полтава", "Ровно", "Сумы", "Тернополь", "Ужгород",
            "Харьков", "Херсон", "Хмельницкий", "Черкассы", "Чернигов", "Черновцы"};

    private String[] aarays2 = {"Винница", "Днепр", "Донецк", "Житомир", "Запорожье",
            "Ивано-Франковск", "Киев", "Кропивницкий", "Луганск", "Луцк", "Львов",
            "Николаев", "Одесса", "Полтава", "Ровно", "Сумы", "Тернополь", "Ужгород",
            "Харьков", "Херсон", "Хмельницкий", "Черкассы", "Чернигов", "Черновцы"};

    private Frame frame;
    private Frame frame2;

    public ControllerFrame() {
        builder = new StringBuilder();
        initAllFildsframeStart();
        initFrameEnd();
        frame.setVisible(true);
        addLoadOneListener();
        addCheckBoxListener();


    }

    private void initAllFildsframeStart() {
        frame = new Frame("УкрЗализныця", 300, 500);
        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        myComboSityFrom = new MyComboBox(aarays);
        myComboSityFrom.setBorder(new TitledBorder("Откуда"));
        myComboSityTo = new MyComboBox(aarays2);
        myComboSityTo.setBorder(new TitledBorder("Куда"));

        teaCheckBox = new MyCheckBox("Чай");
        bedCheckBox = new MyCheckBox("Постель");

        myTextField = new MyTextField();
        myTextField.setBorder(new TitledBorder("Когда"));
        myButton = new MyButton("Заказать");


        manRadioButton = new MyJRadioButton("Оплата наличными");
        womenRadioButton = new MyJRadioButton("Оплата картой");

        myButtonGroup = new MyButtonGroup();
        myButtonGroup.add(manRadioButton);
        myButtonGroup.add(womenRadioButton);

        firstBox = new MyBox(BoxLayout.PAGE_AXIS);
        firstBox.add(myComboSityFrom);
        firstBox.add(Box.createVerticalStrut(32));
        firstBox.add(myComboSityTo);
        firstBox.add(Box.createVerticalStrut(32));
        firstBox.add(myTextField);
        firstBox.add(Box.createVerticalStrut(22));

        secondBox = new MyBox(BoxLayout.PAGE_AXIS);
        secondBox.add(teaCheckBox);
        secondBox.add(bedCheckBox);
        secondBox.setBorder(new TitledBorder("Удобства"));
        secondBox.add(Box.createHorizontalStrut(12));

        thirddBox = new MyBox(BoxLayout.PAGE_AXIS);
        thirddBox.add(manRadioButton);
        thirddBox.add(womenRadioButton);
        thirddBox.add(Box.createHorizontalStrut(20));
        thirddBox.setBorder(new TitledBorder("Вариант оплаты"));
        thirddBox.add(Box.createVerticalStrut(12));

        fourdBox = new MyBox(BoxLayout.PAGE_AXIS);
        fourdBox.add(myButton);

        mainBox.add(firstBox);
        mainBox.add(secondBox);
        mainBox.add(thirddBox);
        mainBox.add(fourdBox);
        frame.setContentPane(mainBox);

    }

    public void setVisibleTwoFrame() {
        frame2.setVisible(true);
        frame.setVisible(false);
    }

    private void initFrameEnd() {
        frame2 = new Frame("УкрЗализныця", 300, 300);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initializeAllFields();
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));

        Box fromBox = Box.createHorizontalBox();
        fromBox.add(fromJLabel);
        //fromBox.add(Box.createHorizontalStrut(6));
        fromBox.add(fromTextField);
        fromBox.add(Box.createVerticalStrut(6));
        Box toBox = Box.createHorizontalBox();
        toBox.add(toLabel);
        //toBox.add(Box.createHorizontalStrut(6));
        toBox.add(toTextField);
        toBox.add(Box.createVerticalStrut(6));

        Box tesBedBox = Box.createHorizontalBox();
        tesBedBox.add(cenvLabel);
        tesBedBox.add(teaTextLabel);
        tesBedBox.add(Box.createVerticalStrut(6));

        Box payBox = Box.createHorizontalBox();
        payBox.add(payLabel);
        payBox.add(Box.createVerticalStrut(6));

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createHorizontalGlue());
        buttonBox.add(btnOk);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(btnCancel);

        mainBox.add(fromBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(toBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(tesBedBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(payBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(buttonBox);

        frame2.setContentPane(mainBox);
        frame2.pack();
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);

        fromTextField.setText((String) myComboSityFrom.getSelectedItem());
        toTextField.setText((String) myComboSityTo.getSelectedItem());


    }

    private void initializeAllFields() {
        fromJLabel = new JLabel("Откуда:");
        toLabel = new JLabel("Куда:");
        fromTextField = new JLabel();
        toTextField = new JLabel();
        btnOk = new MyButton("Оплатить");
        btnCancel = new MyButton("Назад");
        teaTextLabel = new JLabel();
        //bedTextLabel = new JLabel();
        cenvLabel = new JLabel("Услуги:");
        payLabel = new JLabel("Оплата:");
    }

    public void setvisibleOneFrame() {

        frame.setVisible(true);
        frame2.setVisible(false);
    }

    private void addLoadOneListener() {
        myComboSityFrom.addActionListener(e -> {
            fromTextField.setText((String) myComboSityFrom.getSelectedItem());
        });
        myComboSityTo.addActionListener(e -> {
            toTextField.setText((String) myComboSityTo.getSelectedItem());
        });
        myButton.addActionListener(e -> {
            setVisibleTwoFrame();
        });
        btnOk.addActionListener(e -> {

        });
        btnCancel.addActionListener(e -> {
            builder.delete(0, builder.length());
            teaTextLabel.setText(builder.toString());
            setvisibleOneFrame();
        });
        ActionListener listener = e -> {
            switch (((JRadioButton) e.getSource()).getText()) {
                case "Оплата наличными":
                    payLabel.setText("Оплата наличными");
                    break;
                case "Оплата картой":
                    payLabel.setText("Оплата картой");
                    break;
            }
        };
        manRadioButton.addActionListener(listener);
        womenRadioButton.addActionListener(listener);


    }

    private void addCheckBoxListener() {

        bedCheckBox.addItemListener(e -> {
            if (bedCheckBox.isSelected()) {
                builder.append("пастель ");
                teaTextLabel.setText(builder.toString());
            }
        });
        teaCheckBox.addItemListener(e -> {
            if (teaCheckBox.isSelected()) {
                builder.append(" чай ");
                teaTextLabel.setText(builder.toString());
            }
        });

    }
}

import jdk.nashorn.internal.runtime.options.Options;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * <p> This is MainView Class For Personal Information Frame </p>
 * @author Reza Maghsoudi
 * @version 1.0
 * @since 1395/05/12
 */
public class Main {

    private static String[] columnNames={"ID","Name","Family","Address"};
    private static Object[][] data={{123,"ali","abasi","tehran"}};
    private Dimension dimension;
    private JFrame frame_main;
    private JTable jTable_login;
    private JScrollPane jsp_login;

    //-------------------------------------------------------------------- Define MenuBar
    private JMenuBar menu_bar;

    private JMenu jMenu_file;
    private JMenu jMenu_edit;

    private JMenuItem jItem_open;
    private JMenuItem jItem_saveAs;
    private JMenuItem jItem_save;
    private JMenuItem jItem_update;
    private JMenuItem jItem_delete;
    private JMenuItem jItem_clear;
    private JMenuItem jItem_changView;
    private JMenuItem jItem_xml;
    private JMenuItem jItem_report;
    private JMenuItem jItem_pdf;
    private JMenuItem jItem_json;
    private JMenuItem jItem_word;
    private JMenuItem jItem_excel;
    private JMenuItem jItem_exit;

    //-------------------------------------------------------------------- Define All JPanel
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;

    //-------------------------------------------------------------------- Define All Label
    private JLabel lbl_id;
    private JLabel lbl_name;
    private JLabel lbl_family;
    private JLabel lbl_address;

    //-------------------------------------------------------------------- Define All TextBox
    private JTextField txt_id;
    private JTextField txt_name;
    private JTextField txt_family;
    private JTextField txt_address;

    //-------------------------------------------------------------------- Define All Button
    private JButton btn_save;
    private JButton btn_saveAs;
    private JButton btn_update;
    private JButton btn_delete;
    private JButton btn_clear;
    private JButton btn_changView;
    private JButton btn_xml;
    private JButton btn_report;
    private JButton btn_pdf;
    private JButton btn_json;
    private JButton btn_word;
    private JButton btn_excel;

    /**
     *<p>This is initView Method, Use Of This For View Frame</p>
     */
    public void initView() throws IOException
    {
        dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int ws=(int)dimension.getWidth();
        int hs=(int)dimension.getHeight();

        //----------------------------------------------------------------------- Implementation Body Frame
        frame_main=new JFrame("Login Form");
        frame_main.setBounds(0,0,600,730);
        frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_main.setLayout(null);
        Image login= ImageIO.read(new File("src/images/login.png"));
        frame_main.setIconImage(login);
        //frame_main.pack();

        //----------------------------------------------------------------------- Implementation JMenuBar
        menu_bar=new JMenuBar();
        menu_bar.setBounds(0,0,600,20);
        menu_bar.setBackground(Color.ORANGE);

        jMenu_file=new JMenu("File");
        jMenu_edit=new JMenu("Edit");

        jItem_open=new JMenuItem("Open");
        jItem_saveAs=new JMenuItem("Save As");
        jItem_save=new JMenuItem("Save");
        jItem_update=new JMenuItem("Update");
        jItem_delete=new JMenuItem("Delete");
        jItem_clear=new JMenuItem("Clear");
        jItem_changView=new JMenuItem("ChangView");
        jItem_xml=new JMenuItem("XML");
        jItem_report=new JMenuItem("Report");
        jItem_pdf=new JMenuItem("PDF");
        jItem_word=new JMenuItem("Word");
        jItem_excel=new JMenuItem("Excel");
        jItem_json=new JMenuItem("JSon");

        jItem_exit=new JMenuItem("Exit");
        jItem_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        URL url_open=this.getClass().getResource("/images/open.JPG");
        ImageIcon icon_open=new ImageIcon(url_open);
        jItem_open.setIcon(icon_open);

        URL url_save=this.getClass().getResource("/images/save.JPG");
        ImageIcon icon_save=new ImageIcon(url_save);
        jItem_save.setIcon(icon_save);

        URL url_clear=this.getClass().getResource("/images/clear.JPG");
        ImageIcon icon_clear=new ImageIcon(url_clear);
        jItem_clear.setIcon(icon_clear);

        URL url_word=this.getClass().getResource("/images/word.JPG");
        ImageIcon icon_word=new ImageIcon(url_word);
        jItem_word.setIcon(icon_word);

        URL url_excel=this.getClass().getResource("/images/excel.JPG");
        ImageIcon icon_excel=new ImageIcon(url_excel);
        jItem_excel.setIcon(icon_excel);

        /**
         * <p>Set The All JPanel For Frame</p>
         */
        //----------------------------------------------------------------------- Implementation JPanel 1
        jPanel1=new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBounds(0,0,600,hs/2);

        //----------------------------------------------------------------------- Implementation JPanel 2
        jPanel2=new JPanel();
        jPanel2.setLayout(null);
        jPanel2.setBounds(0,20,600,(hs/2)/2);
        jPanel2.setBackground(Color.PINK);

        //------------------------------------------------------------------------ Implementation JPanel 3
        jPanel3=new JPanel();
        jPanel3.setLayout(null);
        jPanel3.setBounds(0,20+(hs/2)/2,600,(hs/2)/2);
        jPanel3.setBackground(Color.RED);

        //------------------------------------------------------------------------ Implementation JPanel 3
        jPanel4=new JPanel(null);
        jPanel4.setBounds(0,hs/2,600,hs/2);
        jPanel4.setBackground(Color.BLUE);

        //------------------------------------------------------------------------ Implementation jTable_login
        jTable_login=new JTable(data,columnNames);
        jsp_login=new JScrollPane(jTable_login);
        jsp_login.setBounds(0,0,600,hs/2);
        jTable_login.setFillsViewportHeight(true);
        TableColumn tableColumn=null;
        for(int i=0;i<columnNames.length;i++)
        {
            tableColumn=jTable_login.getColumnModel().getColumn(i);
            if(i==3){
                tableColumn.setPreferredWidth(200);
            }
            else{
                tableColumn.setPreferredWidth(50);
            }
        }
        //tableColumn.setResizable(false);
        jTable_login.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable_login.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                long id= Long.parseLong(jTable_login.getValueAt(jTable_login.getSelectedRow(),0).toString());
                String name= jTable_login.getValueAt(jTable_login.getSelectedRow(),1).toString();
                String family=jTable_login.getValueAt(jTable_login.getSelectedRow(),2).toString();
                String address=jTable_login.getValueAt(jTable_login.getSelectedRow(),3).toString();

                txt_id.setText(String.valueOf(id));
                txt_name.setText(name);
                txt_family.setText(family);
                txt_address.setText(address);
            }
        });

        /**
         * <p>Set the all Label & TextBox this form to JPanel_1</p>
         */

        //--------------------------------------------------------------- Implementation Label ID
        lbl_id=new JLabel("ID :",JLabel.CENTER);
        lbl_id.setBounds(10,10,70,30);

        //--------------------------------------------------------------- Implementation TextBox ID
        txt_id=new JTextField();
        txt_id.setBounds(90,10,200,30);

        //--------------------------------------------------------------- Implementation Label Name
        lbl_name=new JLabel("Name :",JLabel.CENTER);
        lbl_name.setBounds(10,50,70,30);

        //--------------------------------------------------------------- Implementation TextBox Name
        txt_name=new JTextField();
        txt_name.setBounds(90,50,200,30);

        //--------------------------------------------------------------- Implementation Label Family
        lbl_family=new JLabel("Family :",JLabel.CENTER);
        lbl_family.setBounds(10,90,70,30);

        //--------------------------------------------------------------- Implementation TextBox Family
        txt_family=new JTextField();
        txt_family.setBounds(90,90,200,30);

        //--------------------------------------------------------------- Implementation Label Address
        lbl_address=new JLabel("Address :",JLabel.CENTER);
        lbl_address.setBounds(10,130,70,30);

        //--------------------------------------------------------------- Implementation TextBox Address
        txt_address=new JTextField();
        txt_address.setBounds(90,130,200,30);


        /**
         * <p>set the all Button this form to JPanel_3</p>
         */
        //--------------------------------------------------------------- Implementation Button Save
        btn_save=new JButton("Save");
        btn_save.setBounds(10,10,100,30);

        //--------------------------------------------------------------- Implementation Button Update
        btn_update=new JButton("Update");
        btn_update.setBounds(120,10,100,30);

        //--------------------------------------------------------------- Implementation Button Delete
        btn_delete=new JButton("Delete");
        btn_delete.setBounds(230,10,100,30);

        //--------------------------------------------------------------- Implementation Button Clear
        btn_clear=new JButton("Clear");
        btn_clear.setBounds(340,10,100,30);

        //--------------------------------------------------------------- Implementation Button ChangView
        btn_changView=new JButton("ChangView");
        btn_changView.setBounds(450,10,100,30);

        //--------------------------------------------------------------- Implementation Button XML
        btn_xml=new JButton("XML");
        btn_xml.setBounds(230,50,100,30);

        //--------------------------------------------------------------- Implementation Button Report
        btn_report=new JButton("Report");
        btn_report.setBounds(10,90,100,30);

        //--------------------------------------------------------------- Implementation Button Word
        btn_word=new JButton("Word");
        btn_word.setBounds(120,90,100,30);

        //--------------------------------------------------------------- Implementation Button Excel
        btn_excel=new JButton("Excel");
        btn_excel.setBounds(230,90,100,30);

        //--------------------------------------------------------------- Implementation Button Json
        btn_json=new JButton("Json");
        btn_json.setBounds(340,90,100,30);

        //--------------------------------------------------------------- Implementation Button Pdf
        btn_pdf=new JButton("Pdf");
        btn_pdf.setBounds(450,90,100,30);

        //--------------------------------------------------------------- Implementation Button Save As
        btn_saveAs=new JButton("Save As");
        btn_saveAs.setBounds(230,130,100,30);
        btn_saveAs.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options={"Word","Excel","PDF","XML","Json"};
                Object result=JOptionPane.showInputDialog(frame_main,"Save as type","Save As",JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
            }
        });

        //----------------------------------------------------------------------Add All Items
        frame_main.add(jPanel1);
        frame_main.add(jPanel4);

        menu_bar.add(jMenu_file);
        menu_bar.add(jMenu_edit);

        jMenu_file.add(jItem_open);
        jMenu_file.add(jItem_saveAs);
        jMenu_file.add(jItem_save);
        jMenu_file.add(jItem_update);
        jMenu_file.add(jItem_delete);
        jMenu_file.add(jItem_clear);
        jMenu_file.add(jItem_changView);
        jMenu_file.add(jItem_xml);
        jMenu_file.add(jItem_report);
        jMenu_file.add(jItem_pdf);
        jMenu_file.add(jItem_word);
        jMenu_file.add(jItem_excel);
        jMenu_file.add(jItem_json);
        jMenu_file.add(jItem_exit);

        jItem_saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options={"Word","Excel","PDF","XML","Json"};
                Object result=JOptionPane.showInputDialog(frame_main,"Save as type","Save As",JOptionPane.QUESTION_MESSAGE,null, options,options[0]);
            }
        });

        jPanel1.add(menu_bar);
        jPanel1.add(jPanel2);
        jPanel1.add(jPanel3);

        jPanel2.add(lbl_id);
        jPanel2.add(txt_id);
        jPanel2.add(lbl_name);
        jPanel2.add(txt_name);
        jPanel2.add(lbl_family);
        jPanel2.add(txt_family);
        jPanel2.add(lbl_address);
        jPanel2.add(txt_address);

        jPanel3.add(btn_save);
        jPanel3.add(btn_update);
        jPanel3.add(btn_delete);
        jPanel3.add(btn_clear);
        jPanel3.add(btn_changView);
        jPanel3.add(btn_xml);
        jPanel3.add(btn_report);
        jPanel3.add(btn_word);
        jPanel3.add(btn_excel);
        jPanel3.add(btn_json);
        jPanel3.add(btn_pdf);
        jPanel3.add(btn_saveAs);

        jPanel4.add(jsp_login);

        //----------------------------------------------------------------------- Set All setVisible
        frame_main.setVisible(true);
        jPanel1.setVisible(true);
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);
        jPanel4.setVisible(true);

        jTable_login.setVisible(true);
        jsp_login.setVisible(true);

        menu_bar.setVisible(true);
        jMenu_file.setVisible(true);
        jMenu_edit.setVisible(true);

        jItem_open.setVisible(true);
        jItem_saveAs.setVisible(true);
        jItem_save.setVisible(true);
        jItem_update.setVisible(true);
        jItem_delete.setVisible(true);
        jItem_clear.setVisible(true);
        jItem_changView.setVisible(true);
        jItem_xml.setVisible(true);
        jItem_report.setVisible(true);
        jItem_pdf.setVisible(true);
        jItem_word.setVisible(true);
        jItem_excel.setVisible(true);
        jItem_json.setVisible(true);
        jItem_exit.setVisible(true);

        lbl_id.setVisible(true);
        txt_id.setVisible(true);
        lbl_name.setVisible(true);
        txt_name.setVisible(true);
        lbl_family.setVisible(true);
        txt_family.setVisible(true);
        lbl_address.setVisible(true);
        txt_address.setVisible(true);

        btn_save.setVisible(true);
        btn_update.setVisible(true);
        btn_delete.setVisible(true);
        btn_clear.setVisible(true);
        btn_changView.setVisible(true);
        btn_xml.setVisible(true);
        btn_report.setVisible(true);
        btn_word.setVisible(true);
        btn_excel.setVisible(true);
        btn_json.setVisible(true);
        btn_pdf.setVisible(true);
        btn_saveAs.setVisible(true);

    }

    /**
     * <p>This is main Methods to Run Program</p>
     */
    public static void main(String[] args) throws IOException {
        Main m1=new Main();
        m1.initView();
    }


}
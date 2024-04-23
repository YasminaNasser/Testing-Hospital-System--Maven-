package ProjectTesting.Hospital_Management_System_Testing;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.LinkedList;
import java.util.ArrayList;


public class Doctorwindow {

    private JFrame frmP;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField specialityField;
    private JTextField doctorIdField;
    private JTextField emailField;
    private JTextField departmentField;
    private JTextField consultationFeeField;
    private JSpinner experienceSpinner;
    private JButton btnPrintDetails;
    private Doctor doctor;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Doctorwindow window = new Doctorwindow();
                    window.frmP.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Doctorwindow() {
        initialize();
        doctor = new Doctor();
    }

    private void initialize() {
        frmP = new JFrame();
        frmP.setTitle("Doctor");
        frmP.setBounds(100, 100, 707, 583);
        frmP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmP.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("First name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(10, 20, 103, 14);
        frmP.getContentPane().add(lblNewLabel);
        
        firstNameField = new JTextField();
        firstNameField.setColumns(10);
        firstNameField.setBounds(181, 20, 139, 20);
        frmP.getContentPane().add(firstNameField);
        
        JLabel lblNewLabel_1 = new JLabel("Last name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(10, 45, 103, 14);
        frmP.getContentPane().add(lblNewLabel_1);
        
        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(181, 45, 139, 20);
        frmP.getContentPane().add(lastNameField);
        
        specialityField = new JTextField();
        specialityField.setColumns(10);
        specialityField.setBounds(181, 69, 139, 20);
        frmP.getContentPane().add(specialityField);
        
        JLabel lblSpeciality = new JLabel("Speciality");
        lblSpeciality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblSpeciality.setBounds(10, 69, 103, 20);
        frmP.getContentPane().add(lblSpeciality);
        
        JLabel lblNewLabel_3 = new JLabel("DoctorId");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(10, 100, 103, 14);
        frmP.getContentPane().add(lblNewLabel_3);
        
        doctorIdField = new JTextField();
        doctorIdField.setColumns(10);
        doctorIdField.setBounds(181, 101, 139, 20);
        frmP.getContentPane().add(doctorIdField);
        
        JLabel lblNewLabel_4 = new JLabel("emailAddress");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_4.setBounds(10, 146, 103, 14);
        frmP.getContentPane().add(lblNewLabel_4);
        
        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(181, 147, 187, 20);
        frmP.getContentPane().add(emailField);
        
        JLabel lblNewLabel_5 = new JLabel("Experience Years");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_5.setBounds(10, 182, 151, 28);
        frmP.getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_7 = new JLabel("Department");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_7.setBounds(10, 220, 103, 14);
        frmP.getContentPane().add(lblNewLabel_7);
        
        departmentField = new JTextField();
        departmentField.setColumns(10);
        departmentField.setBounds(181, 220, 139, 20);
        frmP.getContentPane().add(departmentField);
        
        JLabel lblNewLabel_8 = new JLabel("Consultation fee");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_8.setBounds(10, 245, 139, 14);
        frmP.getContentPane().add(lblNewLabel_8);
        
        consultationFeeField = new JTextField();
        consultationFeeField.setColumns(10);
        consultationFeeField.setBounds(181, 245, 139, 20);
        frmP.getContentPane().add(consultationFeeField);
        
        JButton btnNewButton = new JButton("Add");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDoctor();
            }
        });
        btnNewButton.setBounds(35, 289, 125, 46);
        frmP.getContentPane().add(btnNewButton);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(180, 289, 125, 46);
        frmP.getContentPane().add(btnUpdate);
        
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update doctor details
                doctor.setFirstName(firstNameField.getText());
                doctor.setLastName(lastNameField.getText());
                doctor.setSpecialty(specialityField.getText());
                doctor.setDoctorID(doctorIdField.getText());
                doctor.setEmailAddress(emailField.getText());
                doctor.setDepartment(departmentField.getText());
                try {
                    doctor.setExperienceYears(Integer.parseInt(experienceSpinner.getValue().toString()));
                } catch (NumberFormatException ex) {
                    // Handle invalid input for experience years
                }
                try {
                    doctor.setConsultationFee(Double.parseDouble(consultationFeeField.getText()));
                } catch (NumberFormatException ex) {
                    // Handle invalid input for consultation fee
                }

                // You can perform additional actions if needed

                // For example, print doctor details after update
                doctor.printDetails();
            }
        });
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(333, 289, 125, 46);
        frmP.getContentPane().add(btnDelete);

        // Method to clear input fields
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected doctor's ID
                String doctorIDToDelete = doctorIdField.getText();

                // Get the instance of DoctorDataModel
                DoctorDataModel dataModel = DoctorDataModel.getInstance();

                // Get the list of doctors
                LinkedList<Doctor> doctorList = dataModel.getDoctors();

                // Iterate through the list to find the doctor with the matching ID
                for (Doctor doctor : doctorList) {
                    if (doctor.getDoctorID().equals(doctorIDToDelete)) {
                        // Remove the doctor from the list
                        doctorList.remove(doctor);
                        // Optionally, update the GUI to reflect the changes
                        // For example, clear the input fields
                        clearInputFields();
                        // Break the loop after the doctor is found and removed
                        break;
                    }
                }
            }
            
            private void clearInputFields() {
                firstNameField.setText("");
                lastNameField.setText("");
                specialityField.setText("");
                doctorIdField.setText("");
                emailField.setText("");
                departmentField.setText("");
                consultationFeeField.setText("");
                // Clear any other fields if needed
            }
        });

        
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBounds(486, 289, 125, 46);
        frmP.getContentPane().add(btnExit);
        
        experienceSpinner = new JSpinner();
        experienceSpinner.setBounds(181, 189, 30, 20);
        frmP.getContentPane().add(experienceSpinner);
        
        btnPrintDetails = new JButton("Print details");
        btnPrintDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPrintDetails.setBounds(35, 409, 125, 46);
        btnPrintDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printDoctorDetails();
            }
        });
        frmP.getContentPane().add(btnPrintDetails);
        
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(223, 378, 322, 127);
        frmP.getContentPane().add(scrollPane);
    }
    
    private void addDoctor() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String specialty = specialityField.getText();
        String doctorId = doctorIdField.getText();
        String email = emailField.getText();
        String department = departmentField.getText();
        double consultationFee = Double.parseDouble(consultationFeeField.getText());
        int experienceYears = (int) experienceSpinner.getValue();
        
        Doctor doctorToAdd = new Doctor(firstName, lastName, specialty, "", doctorId, email, experienceYears, department, consultationFee, new ArrayList<>());
        DoctorDataModel dataModel = DoctorDataModel.getInstance();
        dataModel.getDoctors().add(doctorToAdd);
    }

    private void printDoctorDetails() {
        DoctorDataModel dataModel = DoctorDataModel.getInstance();
        LinkedList<Doctor> doctors = dataModel.getDoctors();
        StringBuilder details = new StringBuilder("Doctor Details:\n");

        for (Doctor doctor : doctors) {
            details.append("First Name: ").append(doctor.getFirstName()).append("\n");
            details.append("Last Name: ").append(doctor.getLastName()).append("\n");
            details.append("Specialty: ").append(doctor.getSpecialty()).append("\n");
            details.append("Doctor ID: ").append(doctor.getDoctorID()).append("\n");
            details.append("Email Address: ").append(doctor.getEmailAddress()).append("\n");
            details.append("Experience Years: ").append(doctor.getExperienceYears()).append("\n");
            details.append("Department: ").append(doctor.getDepartment()).append("\n");
            details.append("Consultation Fee: $").append(doctor.getConsultationFee()).append("\n\n");
        }
        
        JScrollPane scrollPane = (JScrollPane) frmP.getContentPane().getComponentAt(223, 378);
        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        textArea.setText(details.toString());
    }

    public JFrame getFrame() {
        return frmP;
    }
}

package ProjectTesting.Hospital_Management_System_Testing;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class to represent a medical record
class MedicalRecord {
    private int recordId;
    private String patientName;
    private String diagnosis;
    private String treatment;
    private LocalDate date; 

    public MedicalRecord(int recordId, String patientName, String diagnosis, String treatment, LocalDate date) {
        this.recordId = recordId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.date = date;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

// Class to handle medical records operations
class MedicalRecordsModule {
    private Map<Integer, MedicalRecord> records;

    public MedicalRecordsModule() {
        records = new HashMap<>();
    }

    // Add a new medical record
    public void addMedicalRecord(int recordId, String patientName, String diagnosis, String treatment, LocalDate date) {
        MedicalRecord newRecord = new MedicalRecord(recordId, patientName, diagnosis, treatment, date);
        records.put(recordId, newRecord);
    }

    // Retrieve a medical record by record ID
    public MedicalRecord getMedicalRecord(int recordId) {
        return records.get(recordId);
    }

    // Update a medical record
    public void updateMedicalRecord(int recordId, String diagnosis, String treatment) {
        MedicalRecord record = records.get(recordId);
        if (record != null) {
            record.setDiagnosis(diagnosis);
            record.setTreatment(treatment);
        } else {
            System.out.println("Medical record with ID " + recordId + " not found.");
        }
    }

    // Delete a medical record by record ID
    public void deleteMedicalRecord(int recordId) {
        records.remove(recordId);
    }

    // Search medical records by patient name
    public List<MedicalRecord> searchMedicalRecordsByPatientName(String patientName) {
        List<MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord record : records.values()) {
            if (record.getPatientName().equalsIgnoreCase(patientName)) {
                result.add(record);
            }
        }
        return result;
    }

    // Search medical records by diagnosis
    /*public List<MedicalRecord> searchMedicalRecordsByDiagnosis(String diagnosis) {
        List<MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord record : records.values()) {
            if (record.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                result.add(record);
            }
        }
        return result;
    }

    // Search medical records by date range
    public List<MedicalRecord> searchMedicalRecordsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord record : records.values()) {
            LocalDate recordDate = record.getDate();
            if (recordDate != null && (recordDate.isEqual(startDate) || recordDate.isEqual(endDate) ||
                    (recordDate.isAfter(startDate) && recordDate.isBefore(endDate)))) {
                result.add(record);
            }
        }
        return result;
    }*/

    // Get all medical records
    /*public List<MedicalRecord> getAllMedicalRecords() {
        return new ArrayList<>(records.values());
    }*/

    // Count medical records
    /*public int countMedicalRecords() {
        return records.size();
    }*/

}
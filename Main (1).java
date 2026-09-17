import hospital.doctor.Doctor;
import hospital.patient.Patient;

public class Main {
    private static void displayPatientWithDoctor(Patient patient, Doctor doctor) {
        patient.displayInfo();
        System.out.println("Treating Doctor");
        doctor.displayInfo();
        System.out.println();
    }

    public static void main(String[] args) {
        Doctor cardiologist = new Doctor(101, "Dr. Meera Rao", "Cardiology", 1500.00);
        Doctor dermatologist = new Doctor(102, "Dr. Arjun Singh", "Dermatology", 1000.00);

        Patient patient1 = new Patient(201, "Nisha Patel", "Heart disease", 45);
        Patient patient2 = new Patient(202, "Rahul Verma", "Skin allergy", 30);
        Patient patient3 = new Patient(203, "Kavya Iyer", "Hypertension", 52);

        System.out.println("Patient and Doctor Details\n");
        displayPatientWithDoctor(patient1, cardiologist);
        displayPatientWithDoctor(patient2, dermatologist);
        displayPatientWithDoctor(patient3, cardiologist);

        int cardiologistPatients = 2;
        int dermatologistPatients = 1;
        double cardiologistTotal = cardiologistPatients * cardiologist.getConsultationFee();
        double dermatologistTotal = dermatologistPatients * dermatologist.getConsultationFee();

        System.out.printf("Total fee collected by %s: %.2f%n", cardiologist.getName(), cardiologistTotal);
        System.out.printf("Total fee collected by %s: %.2f%n", dermatologist.getName(), dermatologistTotal);
    }
}

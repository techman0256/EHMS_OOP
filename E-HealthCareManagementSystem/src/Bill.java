import java.util.Scanner;

public class Bill {
    static Scanner sc= new Scanner(System.in);
    int totalAmount;
    
    public static void calculateBill(RegularPatient patient) {
    	if (patient == null) {
        	System.out.println("Patient ID doen't exist, enter correct Patient ID ...");
        	return;
        }
    	
    	patient.patientBill = new Bill();
    	patient.patientBill.totalAmount = 1000;
    	System.out.println("Total Fees : " + patient.patientBill.totalAmount);
    }

    public static void calculateBill(AddmittedPatient patient) {
        if (patient == null) {
        	System.out.println("Patient ID doen't exist, enter correct Patient ID ..");
        	return;
        }
    	if (patient.Status.equals("Released")) {
        	System.out.println("The patients bill already exists ...");
        	return;
        }
    	
    	patient.billPatient = new Bill();
    	System.out.print("Enter the number of days the patient stayed: ");
        patient.no_of_days = sc.nextInt();
        patient.billPatient.totalAmount = (patient.DocFees*patient.no_of_days) + (patient.RoomCharge*patient.no_of_days);
        patient.Status = "Released";
        System.out.println("Total Calculated Amount : " + patient.billPatient.totalAmount);
    }

    public static void printBill(RegularPatient patient) {
//    	if (patient == null) {
//        	System.out.println("Patient ID doen't exist, enter correct Patient ID ...");
//        	return;
//        }
    	
    	System.out.println("\n\n\n\t\t\t_______________________________________________________________________________________");
        System.out.println("\t\t\t                                   PATIENT'S BILL                                            ");
        System.out.println("\t\t\t___________________________________________________________________________________________\n");
        System.out.println("\n\n\n");
	    System.out.print("\t\t\t                   1. NAME OF PATIENT :" + patient.name+"                                        \n");
	    System.out.print("\t\t\t                   2. PATIENT ID      :" + patient.patientID+"                                   \n");
	    System.out.print("\t\t\t                   3. DOCTOR'S FEES   :" + patient.Fees+ "                                       \n");
        System.out.println("\n\n\n\t\t\t_______________________________________________________________________________________");
    }

    public static void printBill(AddmittedPatient patient) {
//    	if (patient == null) {
//        	System.out.println("Patient ID doen't exist, enter correct Patient ID ...");
//        	return;
//        }
    	
    	if (patient.Status.equals("Addmitted")) {
    		System.out.println("The patient is still addmitted you can view bill after when he released"); 
    		return;
    	}
    	
        System.out.println("\n\n\n\t\t\t_______________________________________________________________________________________");
        System.out.println("\t\t\t                                   PATIENT'S BILL                                            ");
        System.out.println("\t\t\t___________________________________________________________________________________________\n");
        System.out.println("\n\n\n");
        
        System.out.print("\t\t\t                   1. NAME OF PATIENT      " + patient.name+"                                   \n");
	    System.out.print("\t\t\t                   2. PATIENT ID           " + patient.patientID+"                              \n");
	    System.out.print("\t\t\t                   3. DAYS OF STAYING      " + patient.no_of_days+ "                            \n");
        System.out.print("\t\t\t                   1. DOCTOR'S FEE PER DAY " + patient.DocFees+"                                   \n");
	    System.out.print("\t\t\t                   2. ROOM CHARGES PER DAY " + patient.RoomCharge+"                             \n");
	    System.out.print("\t\t\t                   3. TOTAL AMOUNT         " + patient.billPatient.totalAmount+ "               \n");

        System.out.println("\n\n\n\t\t\t_______________________________________________________________________________________"); 

    }

    public static void printBill(Patient patient) {
    	if (patient == null) {
        	System.out.println("Patient ID doen't exist, enter correct Patient ID ...");
        	return;
        }
    	
    	if (patient.type.equals(RegularPatient.typePatient)) {
            RegularPatient printPatient = (RegularPatient) patient;
            printBill(printPatient);
        }
        if (patient.type.equals(AddmittedPatient.typePatient)) {
            AddmittedPatient printPatient = (AddmittedPatient) patient;
            printBill(printPatient);
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    String nim;
    String major;

    public Student(String name, String nim, String major) {
        this.name = name;
        this.nim = nim;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Nama: " + name + ", NIM: " + nim + ", Jurusan: " + major;
    }
}

public class StudentManagement {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Masukkan nama mahasiswa: ");
                scanner.nextLine(); // Consume newline
                String name = scanner.nextLine();

                String nim;
                while (true) {
                    System.out.print("Masukkan NIM mahasiswa: ");
                    nim = scanner.nextLine();
                    if (nim.matches("\\d{15}")) {
                        break;
                    }
                    System.out.println("Nim Harus 15 Digit!!!");
                }

                System.out.print("Masukkan jurusan mahasiswa: ");
                String major = scanner.nextLine();

                students.add(new Student(name, nim, major));
                System.out.println("Data mahasiswa berhasil ditambahkan.");

            } else if (choice == 2) {
                System.out.println("Data Mahasiswa:");
                for (Student student : students) {
                    System.out.println(student);
                }
            } else if (choice == 3) {
                System.out.println("Adios");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}
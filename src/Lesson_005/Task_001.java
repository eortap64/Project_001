package Lesson_005;
class Employees {
    String fio, dolzh, email;
    int zarpl, age;
    long phone;
    // Нажимаем Alt + insert и создаем конструктор
    public int getAge() {  //Создали "геттер" для "age"
        return age;
    }
    public Employees(String fio, String dolzh, String email, long phone, int zarpl, int age) {
        this.fio = fio;
        this.dolzh = dolzh;
        this.email = email;
        this.phone = phone;
        this.zarpl = zarpl;
        this.age = age;
    }
    public void printInfo(){
        System.out.println("ФИО: "+fio+" |Должность: "+dolzh+" |Эл.почта: "+email+" "
                +"|Телефон: "+phone+" |Зарплата: "+zarpl+" |Возраст: "+age);
    }
}
public class Task_001 {
    public static void main(String[] args) {
        Employees[] employees = new Employees[5];
        employees[0] = new Employees("Иванов И.П.","Грузчик","ivanov@mail.ru",
                89823432223L, 25000, 32);
        employees[1] = new Employees("Спорынец В. Д.","Водитель","ptret02@mail.ru",
                83670046012L, 32000,41);
        employees[2] = new Employees("Карасёва А. А.","Шеф-повар","pogzh279@mail.ru",
                80122642107L, 42000,52);
        employees[3] = new Employees("Хреножуев П. О.","Генетик","genhren_JL@mail.ru",
                83203231032L, 84000,46);
        employees[4] = new Employees("Тупчук И. Р.","Учитель","spT321Ra@mail.ru",
                82132130344L, 21000,27);
        for (Employees employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}
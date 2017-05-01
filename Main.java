package com.company;

import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.io.*;

        public class Main {
            public static void main(String[] args) {
                int noid = -1;


                String file2 = "C:\\Users\\a\\IdeaProjects\\test\\src\\com\\company\\students.txt";
                List<Student> myList = new ArrayList<Student>();
                try {
                    BufferedReader buf = new BufferedReader(new FileReader(file2));
                    String lineJustFetched;
                    String[] wordsArray;

                    while (true) {
                        Student temp = new Student();
                        lineJustFetched = buf.readLine();
                        if (lineJustFetched == null) {
                            break;
                        } else {
                            wordsArray = lineJustFetched.split("\t");
                            try {
                                long id = Long.parseLong(wordsArray[0]);
                                temp.setId(id);
                            } catch (Exception ex) {
                                temp.setId(noid);
                                noid--;
                            }
                            temp.setCurrentSchool(wordsArray[1]);
                            temp.setLastName(wordsArray[2]);
                            temp.setFirstName(wordsArray[3]);
                            temp.setMiddleName(wordsArray[4]);
                            temp.setDob(wordsArray[5]);
                            char k = wordsArray[6].charAt(0);
                            temp.setGender(k);
                            temp.setGrade(wordsArray[7]);
                        }
                        myList.add(temp);

                    }
                    buf.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("Unable to open file");
                } catch (IOException ex) {
                    System.out.println("error readin file");
                }
             /*   listsort(myList);
                testList50(myList, 0);
                genderCount(myList);
                gradeUniqCount((myList));
                testList50(myList, 1000);
                gradeUniqCountwithkids(myList);
                removeInact(myList);
                testList50(myList, 1000);
                superSort(myList);
                testList50(myList, 1000);
                gradeUniqCountwithkids(myList);
                genderCount(myList);
                testList50(myList, 0);
                testList(myList);
*/
                removeInact(myList);
            }

            public static void superSort(List<Student> list) {
                Student temp;
                Student temp1;
                int i;
                int j;
                int byFirst = 0, byLast = 0, byGrade = 0, bySchool = 0;
                for (i = 0; i < list.size(); i++) {
                    for (j = 0; j < list.size() - 1; j++) {
                        temp = list.get(j);
                        temp1 = list.get(j + 1);
                        if (temp.getCurrentSchool().compareTo(temp1.getCurrentSchool()) > 0) {
                            list.set(j, temp1);
                            list.set(j + 1, temp);
                            bySchool++;
                        }
                        if (temp.getCurrentSchool().compareTo(temp1.getCurrentSchool()) == 0) {
                            if (temp.getGrade().compareTo(temp1.getGrade()) > 0) {
                                list.set(j, temp1);
                                list.set(j + 1, temp);
                                byGrade++;
                            }
                            if (temp.getGrade().compareTo(temp1.getGrade()) == 0) {
                                if (temp.getLastName().compareTo(temp1.getLastName()) > 0) {
                                    list.set(j, temp1);
                                    list.set(j + 1, temp);
                                    byLast++;
                                }
                                if (temp.getLastName().compareTo(temp1.getLastName()) == 0) {
                                    if (temp.getFirstName().compareTo(temp1.getFirstName()) > 0) {
                                        list.set(j, temp1);
                                        list.set(j + 1, temp);
                                        byFirst++;
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(bySchool + " " + byGrade + " " + byLast + " " + byFirst);
            }


            public static void genderCount(List<Student> list) {
                Student temp;
                int m = 0;
                int f = 0;
                int oops = 0;
                for (int i = 0; i < list.size(); i++) {
                    temp = list.get(i);
                    if (temp.getGender() != 'M' && temp.getGender() != 'F') {
                        oops++;
                    }
                    if (temp.getGender() == 'M') {
                        m++;
                    } else {
                        f++;
                    }
                }
                System.out.println("female = " + f + " male = " + m + " total =" + (f + m) + " " + oops);
            }

            public static void testList(List<Student> list) {
                Student temp;
                for (int k = 0; k < list.size(); k++) {
                    temp = list.get(k);
                    System.out.println(temp.getId() + " " + temp.getCurrentSchool() + " " + temp.getLastName() + " " + temp.getFirstName() + " " + temp.getGrade());
                }
            }

            public static void testList50(List<Student> list, int index) {
                Student temp;
                try {
                    for (int k = index; k < index + 20; k++) {
                        temp = list.get(k);
                        System.out.println(temp.getLastName() + " " + temp.getFirstName()+" ");
                    }
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("End of the List is reached");

                }
            }

            public static void listsort(List<Student> list) {
                Student temp;
                Student temp1;
                int i;
                int j;
                for (i = 0; i < list.size(); i++) {
                    for (j = 0; j < list.size() - 1; j++) {
                        temp = list.get(j);
                        temp1 = list.get(j + 1);
                        if (temp.getLastName().compareTo(temp1.getLastName()) > 0) {
                            list.set(j, temp1);
                            list.set(j + 1, temp);
                        }
                        if (temp.getLastName().compareTo(temp1.getLastName()) == 0) {
                            if (temp.getFirstName().compareTo(temp1.getFirstName()) > 0) {
                                list.set(j, temp1);
                                list.set(j + 1, temp);
                            }
                        }
                    }
                }
            }

            public static void gradeUniqCount(List<Student> list) {
                String[] uniqueCount = new String[50];
                Student temp;
                int j = 0;
                int count;
                boolean operator;
                while (j < list.size()) {
                    temp = list.get(j);
                    count = 0;
                    operator = true;
                    while (operator) {
                        if (uniqueCount[count] == null) {
                            uniqueCount[count] = temp.getGrade();
                            j++;
                            operator = false;
                        }
                        if (uniqueCount[count].equals(temp.getGrade())) {
                            operator = false;
                            j++;
                        }
                        if (!uniqueCount[count].equals(temp.getGrade()) && uniqueCount[count] != null) {
                            count++;
                        }
                    }
                }
                int printCount = 0;
                while (uniqueCount[printCount] != null) {
                    System.out.print(uniqueCount[printCount] + ", ");
                    printCount++;
                }
                System.out.println();
            }


            public static void gradeUniqCountwithkids(List<Student> list) {
                String[] uniqueCount = new String[50];
                int[] totalStudents = new int[50];
                Student temp;
                int j = 0;
                int count;
                boolean operator;
                while (j < list.size()) {
                    temp = list.get(j);
                    count = 0;
                    operator = true;
                    while (operator) {
                        if (uniqueCount[count] == null) {
                            uniqueCount[count] = temp.getGrade();
                            totalStudents[count]++;
                            j++;
                            operator = false;
                        }
                        if (uniqueCount[count].equals(temp.getGrade())) {
                            operator = false;
                            totalStudents[count]++;
                            j++;
                        }
                        if (!uniqueCount[count].equals(temp.getGrade()) && uniqueCount[count] != null) {
                            count++;
                        }
                    }
                }
                int printCount = 0;
                while (uniqueCount[printCount] != null) {
                    System.out.println("Grade " + uniqueCount[printCount] + " =" + totalStudents[printCount] + " students");
                    printCount++;
                }

            }

            public static void removeInact(List<Student> list) {
                Student temp = new Student();
                int count = 0;
                for (int i = 0; i < list.size(); i++) {
                    temp = list.get(i);
                    if (temp.getCurrentSchool().compareTo("INACT") == 0) {
                        list.remove(i);
                        count++;
                        i--;
                    }
                }
                System.out.println(count);

            }
        }
    /*public static void quicksort(List<Student> list, int p , int r){
            if(p<r){
                int q = partition(list,p,r);
                if(q == r){
                    q--;
                }
                quicksort(list,p,q);
                quicksort(list,q+1,r);
            }
    }
    public static int partition(List<Student> list, int p, int r){
        Student temp = new Student();
        temp = list.get(p);
        String pivot = temp.getLastName();
        int lo = p;
        int hi = r;

        while(true){
            temp = list.get(hi);
            while(temp.getLastName().compareTo(pivot)>=0 && lo <hi){
                //student problem
                hi--;
            }
            temp = list.get(lo);
            while(temp.getLastName().compareTo(pivot)<0 && lo <hi){
                //student problem
                lo++;
            }
            if(lo <hi){
                Student temp2= list.get(lo);
                Student temp5 = list.get(hi);
                list.set(lo, temp5);
                list.set(hi, temp2);
            }
            else return hi;
        }
    }*/


package Encryption;

import java.util.*;
public class EncryptionProgram {

    private Scanner inp;
    private Random ram;
    private ArrayList<Character> list;
    private ArrayList<Character> newList;
    private char charts;
    private char[] letters;


    //Constractor
     EncryptionProgram() {

         inp = new Scanner(System.in);
         ram = new Random();
         list = new ArrayList();
         newList = new ArrayList();
         charts = ' ' ;
         setKey();
         callMethods();
    }


            // Choose the method you want to call
          private void callMethods(){

                while(true) {
                    System.out.println("----------------------------------------------------------------");
                System.out.println("Type \"e\" to Encrypt\n\"d\" to Decrypt\n\"q\" to Quit");


                char response = Character.toUpperCase/*changing the word to uppercase*/(inp.nextLine().charAt(0)/*Getting the first letter*/);


                switch (response){
                    //Calling methods using the first Letter
                case 'E':

                  encrypte();
                    break;
                     case 'D':
                    //call a method
                         decrypte();
                    break;
                     case 'Q':
                    quit();
                         System.out.println("Thank you");
                    break;
                default:
                    System.out.println("please choose from the list");
                }
                System.out.println();

                }



          }




    public void setKey(){
        charts = ' ' ;
        list.clear();
        newList.clear();

        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(charts));
            charts++;

        }
        newList = new ArrayList(list);
        Collections.shuffle(newList);
        System.out.println("created");


    }

//       private void getKey(){
//          System.out.println("key----");
//
//          for(Character x: list){
//              System.out.print(x);
//          }
//
//          for(Character x : newList){
//              System.out.print(x);
//          }
//          System.out.println("newKey");
//
//    }

       //encryption
      private void encrypte(){
            System.out.println("-----enter the password you want to Encrypt----");
            String password = inp.nextLine();
            //smous
            letters = password.toCharArray();

            for (int i = 0; i < letters.length; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if(letters[i]==list.get(j)){
                        letters[i] = newList.get(j);
                    break;
                    }

                }

            }
            System.out.println("encrypted password");
            for(char x : letters){
                System.out.print(x);
            }
            System.out.println();

    }

      //decryption
      private void decrypte(){

              System.out.println("enter an encrypted password to decrypt it ");
              String password = inp.nextLine();
              letters = password.toCharArray();

              for (int i = 0; i < letters.length; i++) {
                  for (int j = 0; j < newList.size(); j++) {
                      if(letters[i]== newList.get(j)){
                          letters[i] = list.get(j);

                      }

                  }

              }
              //Display the output
              System.out.println("Decrypted password");
              for( char x : letters){
                  System.out.print(x);
              }
              System.out.println();

    }
      private void quit(){
          System.exit(0);
      }
}

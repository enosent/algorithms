package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 16.
 * Time: 오후 2:28
 * To change this template use File | Settings | File Templates.
 */
public class Interpreter {

    int[] register = new int[10];
    int[] ram = new int[1000];

    public void interpreter(int caseNumber, int[] inputs){
        int process;
        int address;

        for(int i = 0; i < inputs.length; i++){
            ram[i] = inputs[i];
        }

        for(int i = 0; i < caseNumber; i++){
            if(i != 0) System.out.println();

            process = 0;
            address = 0;
            while(true){
                int command = ram[address];
                address++;
                process++;

                if(command == 100) break;

                int question = command/100;
                int param1 = (command%100)/10;
                int param2 = (command%100)%10;

                switch (question){
                    case 2:
                        register[param1] = param2;
                        break;
                    case 3:
                        register[param1] = (register[param1] + param2)%1000;
                        break;
                    case 4:
                        register[param1] = (register[param1] * param2)%1000;
                        break;
                    case 5:
                        register[param1] = register[param2];
                        break;
                    case 6:
                        register[param1] = (register[param1] + register[param2])%1000;
                        break;
                    case 7:
                        register[param1] = (register[param1]*register[param2])%1000;
                        break;
                    case 8:
                        register[param1] = ram[register[param2]];
                        break;
                    case 9:
                        ram[register[param2]] = register[param1];
                        break;
                    case 0:
                        if(register[param2] != 0){
                            address = register[param1];
                        }
                        break;
                }

            }
            System.out.println(process);

        }

    }

}

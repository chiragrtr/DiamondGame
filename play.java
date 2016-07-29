/**
 * Created by pandeyk on 7/29/2016.
 */
public void play() {
        for(int i = 0; i < diamonds.length; i++){
        System.out.println("Current diamond is:\n" + diamonds[i]);
        System.out.println("What's your bid?:\n");

        int computerBid = getComputerBid(diamonds[i].pip);
        Scanner sc = new Scanner(System.in);
        int userBid = sc.nextInt();
        while(isInvalid(userBid)){
        userBid = sc.nextInt();
        }

        if(userBid < computerBid){
        System.out.println("Sorry, Computer won this bid");
        computerMoney += (float)diamonds[i].pip;
        }
        else if(userBid == computerBid){
        System.out.println("It's a tie; You get half the money");
        computerMoney += (float)diamonds[i].pip / 2;
        userMoney += (float)diamonds[i].pip / 2;
        }
        else{
        System.out.println("Congrats you won this bid");
        userMoney += (float)diamonds[i].pip;
        }
        }
        System.out.println(computerMoney > userMoney ? "You lost" : "Congratulations you won the game");
        System.out.println("Computer has " + computerMoney + " money, and you have " + userMoney);
        }

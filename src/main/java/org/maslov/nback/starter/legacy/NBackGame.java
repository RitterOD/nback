/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.maslov.nback.starter.legacy;

import java.math.*;

public class NBackGame {

    public NBackGame(int step, int moveAmnt, int moveTime, double insert_prob) {
        this.step = step;
        this.moveAmnt = moveAmnt;
        this.moveTime = moveTime;
        this.insert_prob = insert_prob;
        this.cur_move    = 0;
    }

 
        private int cur_move; // Текущий номер шага
        private int step; // Шаг игры : 1 - назад, 2 - назад, ... , n - назад

    /**
     * Get the value of step
     *
     * @return the value of step
     */
    public int getStep() {  
        return step;
    }

    private int moveAmnt;

    /**
     * Get the value of moveAmnt
     *
     * @return the value of moveAmnt
     */
    public int getMoveAmnt() {
        return moveAmnt;
    }

        private int moveTime;

    /**
     * Get the value of moveTime
     *
     * @return the value of moveTime
     */
    public int getMoveTime() {
        return moveTime;
    }
    
    private double insert_prob;

    public double getInsert_prob() {
        return insert_prob;
    }


    private String[] gameStrings;

    /**
     * Get the value of gameStrings
     *
     * @return the value of gameStrings
     */
    public String[] getGameStrings() {
        return gameStrings;
    }

        private boolean[] gameMarks;
        private boolean[] gamerMarks;
        boolean getGameMarkCurMove()
        {
            return gameMarks[cur_move];
        }
        
        boolean getGamerMarkCurMove()
        {
            return gamerMarks[cur_move];
        }
        
        void serGamerMarkCurMove()
        {
            gamerMarks[cur_move] = true;
        }
        void incrementMove()
        {
            ++cur_move;
        }        
        
        boolean lastMove()
        {
            if(cur_move == moveAmnt)
            {
                return true;
            }
            else
            {
                return false;
            }    
        }
        String getCurMoveStr()
        {
            return gameStrings[cur_move];
        }
        
        int getCurMove()
        {
            return cur_move;
        
        }        
        
    /**
     * Get the value of gameMarks
     *
     * @return the value of gameMarks
     */
    public boolean[] getGameMarks() {
        return gameMarks;
    }

        private int num_insertions;

    /**
     * Get the value of num_insertions
     *
     * @return the value of num_insertions
     */
    public int getNum_insertions() {
        return num_insertions;
    }

    private int num_miss;

    /**
     * Get the value of num_miss
     *
     * @return the value of num_miss
     */
    public int getNum_miss() {
        return num_miss;
    }

    /**
     * Set the value of num_miss
     *
     * @param num_miss new value of num_miss
     */
    public void setNum_miss(int num_miss) {
        this.num_miss = num_miss;
    }

    private int num_match;

    /**
     * Get the value of num_match
     *
     * @return the value of num_match
     */
    public int getNum_match() {
        return num_match;
    }
    
    void incrementNum_match()
    {
        ++this.num_match;
    }
    
    void incrementNum_miss()
    {
        ++this.num_miss;
    }        

    /**
     * Set the value of num_match
     *
     * @param num_match new value of num_match
     */
    public void setNum_match(int num_match) {
        this.num_match = num_match;
    }

    public void generateGame()
    {
        gameStrings = new String[this.getMoveAmnt()];
        gameMarks   = new boolean[this.getMoveAmnt()];
        gamerMarks   = new boolean[this.getMoveAmnt()];
        boolean inInjection = false;
        int     numBeforeInjection = 0;
        String  injStr = "";
        for(int numMove = 0; numMove < moveAmnt; ++ numMove)
        {
            gamerMarks[numMove] = false;
            if(inInjection)
            {
                if(numBeforeInjection == 1)
                {
                    gameStrings[numMove] = injStr;
                    gameMarks[numMove]   = true;
                    ++this.num_insertions;
                    inInjection = false;
                }
                else
                {
                    gameStrings[numMove] = getRandomString();
                    gameMarks[numMove]   = false;
                    --numBeforeInjection;
                }    
            }
            else
            {
                if(turnOnIjection())
                {
                    gameStrings[numMove] = injStr = getRandomString();
                    numBeforeInjection = getStep(); 
                    gameMarks[numMove]   = false;
                    inInjection = true;
                }
                else
                {
                    gameStrings[numMove]  = getRandomString();
                    gameMarks[numMove]   = false;
                }    
                
            }    
        
        }
    }        
    
    public void  printGeneratedGame()
    {
        for(int numMove = 0; numMove < moveAmnt; ++numMove)
        {
            System.out.println(numMove +" :" + gameStrings[numMove] 
                    + "  " + gameMarks[numMove]);
        }    
    }        
    
    
    private static String getRandomString()
    {
        String retval;
        double randNum = 35 * Math.random();
        int randInt  = (int)Math.round(randNum);
        switch(randInt)
        {
            case 0:
                retval = "A";
            break;    
            case 1:
                retval = "B";
            break;
            case 2:
                retval = "C";
            break;    

            case 3:
                retval = "D";
            break;
                
            case 4:
                retval = "E";
            break;
                
            case 5:
                retval = "F";
            break;
            case 6:
                retval = "G";
            break;
            case 7:
                retval = "H";
            break;
            case 8:
                retval = "I";
            break;
            case 9:
                retval = "J";
            break;
            case 10:
                retval = "K";
            break;
            case 11:
                retval = "L";
            break;
            case 12:
                retval = "M";
            break;
            case 13:
                retval = "N";
            break;
            case 14:
                retval = "O";
            break;
            case 15:
                retval = "P";
            break;
            case 16:
                retval = "Q";
            break;
            case 17:
                retval = "R";
            break;
            case 18:
                retval = "S";
            break;
            case 19:
                retval = "T";
            break;
            case 20:
                retval = "U";
            break;
            case 21:
                retval = "V";
            break;
            case 22:
                retval = "W";
            break;
            case 23:
                retval = "X";
            break;
            case 24:
                retval = "Y";
            break;
            case 25:
                retval = "Z";
            break;
            case 26:
                retval = "1";
            break;
            case 27:
                retval = "2";
            break;
            case 28:
                retval = "3";
            break;
            case 29:
                retval = "4";
            break;
            case 30:
                retval = "5";
            break;
            case 31:
                retval = "6";
            break;
            case 32:
                retval = "7";
            break;
            case 33:
                retval = "8";
            break;
            case 34:
                retval = "9";
            break;
            case 35:
                retval = "0";
            break;
            default:
                System.out.println("Error in getRandomString");
                System.out.println(randInt);
                retval = "ERROR";
        }      
        return retval;
    }
    
    private boolean turnOnIjection()
    {
        double randVal = Math.random();
        if(randVal <getInsert_prob())
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }  
    
    @Override
    public String toString()
    {
        StringBuilder strBldr = new StringBuilder();
        //strBldr.
        for(int i = 0; i < this.moveAmnt; ++i)
        {
            strBldr.append(this.gameStrings[i]);
            strBldr.append("    ; ");
        }    
        strBldr.append("\n");
        
        for(int i = 0; i < this.moveAmnt; ++i)
        {
            strBldr.append(this.gameMarks[i]);
            if(this.gameMarks[i])
            {
                strBldr.append(" ; ");
            }
            else
            {    
                strBldr.append("; ");
            }
        }
        strBldr.append("\n");
        for(int i = 0; i < this.moveAmnt; ++i)
        {
            strBldr.append(this.gamerMarks[i]);
            if(this.gamerMarks[i])
            {
                strBldr.append(" ; ");
            }
            else
            {    
                strBldr.append("; ");
            }
        }
        strBldr.append("\n");
        strBldr.append(this.moveAmnt);
        strBldr.append(" ");
        strBldr.append(this.num_insertions);
        strBldr.append(" ");
        strBldr.append(this.num_match);
        strBldr.append(" ");
        strBldr.append(this.num_miss);
        strBldr.append("\n");
        return strBldr.toString();
    }
    
    public static void main(String[] args)
    {
        NBackGame game1 = new NBackGame(2, 100, 3, 0.5);
        NBackGame game2 = new NBackGame(2, 100, 3, 0.5);
        game1.generateGame();
        game2.generateGame();
        System.out.println("GAME 1");
        game1.printGeneratedGame();
        System.out.println("GAME 2");
        game2.printGeneratedGame();
        System.out.println(game2.toString());
    }        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadedsocket;

import java.io.*;
import java.net.*;
import java.util.logging.*;


/**
 *
 * @author dwanderson
 */
public class ThreadedSocket extends Thread {
    private final Socket socket;
    public ThreadedSocket(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine = null;
            while (!socket.isClosed()) {
                inputLine = in.readLine();
                if (inputLine == null) {
                    break;
                } else {
                    String response = processInputString(inputLine);
                    out.println(response);
                }
            }
        } catch (IOException ioe) {
            Logger.getLogger(ThreadedSocket.class.getName()).log(Level.SEVERE,
                    null, ioe);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ioe) {
                Logger.getLogger(ThreadedSocket.class.getName()).log(
                    Level.SEVERE, null, ioe);
            }
        }
        
    }
    private String processInputString(String inputLine) {
        String outputLine = "";
        String[] fields = inputLine.split(":");
        if (fields.length != 7) {
            outputLine = "-0.01:We require 7 integer fields, in " + 
                    "yyyy:mm:dd:yyyy:mm:dd:$ format, but we found " +
                    fields.length + " fields. Try again please!";
            return outputLine;
        }
        int startYear = 0;
        int startMonth = 0;
        int startDay = 0;
        int endYear = 0;
        int endMonth = 0;
        int endDay = 0;
        int price = 0;
        try {
            startYear = Integer.parseInt(fields[0]);
            startMonth = Integer.parseInt(fields[1]);
            startDay = Integer.parseInt(fields[2]);
            endYear = Integer.parseInt(fields[3]);
            endMonth = Integer.parseInt(fields[4]);
            endDay = Integer.parseInt(fields[5]);
            price = Integer.parseInt(fields[6]);
        } catch (NumberFormatException nfe) {
            outputLine = "-0.01:Ran into an error parsing the fields between" +
                    "the \":\"; these should all be ints (NO float, even for " +
                    "rate!)";
            return outputLine;
        }
        BookingDay startDate = new BookingDay(startYear, startMonth, startDay);
        BookingDay endDate = new BookingDay(endYear, endMonth, endDay);
        if (!startDate.isValidDate()) {
            outputLine = "-0.01:Start Date for hike is not valid";
            return outputLine;
        } else if (!endDate.isValidDate()) {
            outputLine = "-0.01:End Date for hike is not valid";
            return outputLine;
        }
        Rates rate = new Rates();
        rate.setBaseRate(price);
        rate.setBeginDate(startDate);
        rate.setEndDate(endDate);
        if (!rate.isValidDates()) {
            outputLine = "-0.01:" + rate.getDetails();
            return outputLine;
        }
        double cost = rate.getCost();
        outputLine = cost + ":Quoted Rate";
        return outputLine;
    }
}

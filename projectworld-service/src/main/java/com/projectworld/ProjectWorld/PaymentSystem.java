package com.projectworld.ProjectWorld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

enum TransactionType {
	P2M, P2P, Self
}

class TransactionSummary {
	int transactionId;
	boolean isSenderEligibleForReward;
}

class Payment {
	Map<String, Integer> txnCountMap = new HashMap<>();
	Map<Integer, Integer> senderIdToTnxCountMap = new HashMap<>();
	static int p2mCount = 1;
	static int p2pCount = 1;
	static int selfCount = 1;

	TransactionSummary makePayment(int transactionId, int senderId, int amount, TransactionType transactionType) {
		TransactionSummary obj = new TransactionSummary();
		if (transactionType == TransactionType.P2M) {
			// senderIdToTnxCountMap.put(Integer.valueOf(senderId), p2mtnxcount++);
			txnCountMap.put("P2M", p2mCount++);
			obj.transactionId = transactionId;
			obj.isSenderEligibleForReward = true;
		} else if (transactionType == TransactionType.P2M) {
			// senderIdToTnxCountMap.put(Integer.valueOf(senderId), p2ptnxcount++);
			txnCountMap.put("P2P", p2pCount++);
			obj.transactionId = transactionId;
			obj.isSenderEligibleForReward = true;
		} else {
			// senderIdToTnxCountMap.put(Integer.valueOf(senderId), selftnxcount++);
			txnCountMap.put("Self", selfCount++);
		}
		return obj;
	}

	int getNumberOfTransactions(int senderId, TransactionType transactionType) {
		if (txnCountMap.containsKey(transactionType.P2M)
				&& senderIdToTnxCountMap.containsKey(Integer.valueOf(senderId))) {
			System.out.println(txnCountMap.containsKey(transactionType.P2M));
			System.out.println(senderIdToTnxCountMap.containsKey(Integer.valueOf(senderId)));
			return senderIdToTnxCountMap.get(Integer.valueOf(senderId));
		}
		return 0;
	}
}

public class PaymentSystem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int totalNumberOfRequests = Integer.parseInt(br.readLine().trim());
		Payment payment = new Payment();

		String arr[];

		while (totalNumberOfRequests-- > 0) {
			arr = br.readLine().split(" ");
			int transactionId, senderId, amount;
			TransactionType transactionType;
			switch (arr[0]) {
			case "makePayment":
				transactionId = Integer.parseInt(arr[1]);
				senderId = Integer.parseInt(arr[2]);
				amount = Integer.parseInt(arr[3]);
				transactionType = TransactionType.valueOf(arr[4]);
				TransactionSummary transactionSummary = payment.makePayment(transactionId, senderId, amount,
						transactionType);
				out.print(transactionSummary.transactionId + " " + transactionSummary.isSenderEligibleForReward + "\n");
				break;
			case "getNumberOfTransactions":
				senderId = Integer.parseInt(arr[1]);
				transactionType = TransactionType.valueOf(arr[2]);
				int res = payment.getNumberOfTransactions(senderId, transactionType);
				out.print(res + "\n");
			}
		}
		out.flush();
		out.close();
	}
}

/*
 * 4 makePayment 0 2 100 P2P makePayment 1 4 18 P2M makePayment 2 2 50 P2P
 * getNumberOfTransactions 2 P2P
 * 
 * 
 * 
 * op 0 false 1 true 2 false 2
 * 
 * 
 * 6 makePayment 0 2 100 P2P makePayment 1 4 18 P2M makePayment 2 2 50 P2P
 * makePayment 2 2 50 Self makePayment 2 2 500 P2P getNumberOfTransactions 2 P2P
 * 
 * op 0 false 1 true 2 false 2 false 2 false 3
 */

package com.projectworld.ProjectWorld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum TransactionType {
	P2M, P2P, Self
}

class TransactionSummary {
	int transactionId;
	boolean isSenderEligibleForReward;

	TransactionSummary(int txnId, boolean isTrue) {
		transactionId = txnId;
		isSenderEligibleForReward = isTrue;
	}
}

class Payment {
	Map<String, Integer> txnCountMap = new HashMap<>();
	Map<Integer, Integer> senderIdToTnxCountMap = new HashMap<>();
	List<Map<Integer, TransactionType>> list = new ArrayList<>();
	static int p2mCount = 1;
	static int p2pCount = 1;
	static int selfCount = 1;

	TransactionSummary makePayment(int transactionId, int senderId, int amount, TransactionType transactionType) {
		TransactionSummary txnSummaryObj = new TransactionSummary(transactionId, false);
		Map<Integer, TransactionType> txnDetailMap = new HashMap<>();
		if (transactionType == TransactionType.P2P) {
			txnDetailMap.put(senderId, transactionType);
			txnSummaryObj = new TransactionSummary(transactionId, false);
			list.add(txnDetailMap);
		} else if (transactionType == TransactionType.P2M) {
//			System.out.println("Size: "+list.size());
			if (list.size() < 100) {
//				System.out.println("If");
				txnSummaryObj = new TransactionSummary(transactionId, true);
			}else {
//				System.out.println("Else");
				for (int i=0;i<100;i++) {
					if(list.get(i).containsKey(senderId)) {
						txnSummaryObj = new TransactionSummary(transactionId, true);
					}
				}
			}
			txnDetailMap.put(senderId, transactionType);
			list.add(txnDetailMap);
		} else {
			txnDetailMap.put(senderId, transactionType);
			list.add(txnDetailMap);
			txnSummaryObj = new TransactionSummary(transactionId, false);
		}
		return txnSummaryObj;
	}

	int getNumberOfTransactions(int senderId, TransactionType transactionType) {
		int count = 0;
		for (Map<Integer, TransactionType> obj : list) {
			if (obj.containsKey(senderId) && obj.get(senderId) == transactionType) {
				count++;
			}
		}
		return count;
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
4
makePayment 0 2 100 P2P
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
getNumberOfTransactions 2 P2P

op 
0 false 
1 true 
2 false 
2

6
makePayment 0 2 100 P2P
makePayment 1 4 18 P2M
makePayment 2 2 50 P2P
makePayment 2 2 50 Self
makePayment 2 2 500 P2P
getNumberOfTransactions 2 P2P

op 
0 false 
1 true 
2 false 
2 false 
2 false 
3


103
makePayment 0 2 100 P2P
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 500 P2M
makePayment 1 4 18 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 2 2 50 P2M
makePayment 6 7 50 P2M
getNumberOfTransactions 2 P2M

op
0 false
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
1 true
2 true
2 true
2 true
6 false
75
*/
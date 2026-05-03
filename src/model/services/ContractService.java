package model.services;
import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService online_Payment_Service;
	
	public ContractService() {
	}

	public ContractService(OnlinePaymentService online_Payment_Service) {
		this.online_Payment_Service = online_Payment_Service;
	}
		
	public void processContract(Contract contract, int months){
		double basicQuota = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = online_Payment_Service.interest(basicQuota, i);
			double paymentFee = online_Payment_Service.paymentFee(basicQuota + interest);
			double totalValue = basicQuota + interest + paymentFee;
			contract.getInstallment().add(new Installment(dueDate, totalValue));
		}
	}
}

package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions {

	     if(!checkOut.after(checkIn) ) {
				throw new  DomainExceptions("Check-out date must be after check-in date");
		
	}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	
	public Date getCheckOut() {
		return checkOut;
	}

	//Calcular a dura��o de dias com base na diferen�a entre as duas datas;
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //Aqui pego a diferenca entre as datas em milsegundo e depois tenho que converter para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	
	//Agora atualizar as datas, isto �, vai receber um valor Date para o checkIn e outro valor date para o checkOut
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions {
		
		//Atualiza��o das datas:
			     
			     Date now = new Date();
			     if(checkIn.before(now) ||  checkOut.before(now)) {
			    	throw new DomainExceptions("Reservation dates for update must be future dates");
			     }
			     if(checkIn.before(now)) {
			    	 throw new DomainExceptions("Reservation dates for update must be future dates");
			     }
			     
			     
			     this.checkIn= checkIn;
			     this.checkOut= checkOut;
			   
			     
			     /*Notas Importantes:
			      * 
			       1- Este metodo Date now diz nos resumidamente que no 1� If se a datas que quero atualizar
			        do checkIn ou do checkOut for antes das datas anteriores n�o podemos atualizar
			        
			       2- No 2� If estamos a dizer se a data do checkOut n�o for depois da data do checkIn
			          ir� dar um erro como mensagem.
			          
			        
			       3 - Por fim como o metodo retorna uma string, se acontecer tudo certo e eu atualizar as datas
			             vou ter que retornar uma string, s� que agora para indicar que n�o teve nenhum erro,
			             irei mandar retornar null;
			             
			        4- Se retornar alguma string que n�o tenha dado null, � porque deu algum erro e ai vou ter que tratar;  */
	}
		
	@Override 
	public String toString() {
		
		return "Reservation: Room" +
				roomNumber + 
				", check-in: " +
				sdf.format(checkIn) +
				", check-out: " +
				sdf.format(checkOut) +
				", "+
				duration()+
				" nights";
	}
}

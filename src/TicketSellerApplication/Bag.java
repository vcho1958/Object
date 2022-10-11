package TicketSellerApplication;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public boolean hasInvitation(){return invitation != null;}
    public boolean hasTicket(){return ticket != null;}
    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    public Bag(Long amount) {
        this(amount, null);
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }
        minusAmount(ticket.getFee());
        setTicket(ticket);
        return ticket.getFee();
    }
}

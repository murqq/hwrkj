import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    private AviaSouls aviaSouls;

    @BeforeEach
    public void setup() {
        aviaSouls = new AviaSouls();
    }

    @Test
    public void testAddAndGetAllTickets() {
        Ticket ticket1 = new Ticket("Moscow", "London", 100, 10, 15);
        Ticket ticket2 = new Ticket("Paris", "New York", 200, 12, 18);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expectedTickets = {ticket1, ticket2};
        Ticket[] actualTickets = aviaSouls.findAll();

        Assertions.assertArrayEquals(expectedTickets, actualTickets);
    }

    @Test
    public void testSearch() {
        Ticket ticket1 = new Ticket("Moscow", "London", 100, 10, 15);
        Ticket ticket2 = new Ticket("Paris", "New York", 200, 12, 18);
        Ticket ticket3 = new Ticket("Moscow", "Berlin", 150, 11, 16);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expectedTickets = {ticket3};
        Ticket[] actualTickets = aviaSouls.search("Moscow", "Berlin");

        Assertions.assertArrayEquals(expectedTickets, actualTickets);
    }

    @Test
    public void testSearchAndSortBy() {
        Ticket ticket1 = new Ticket("Moscow", "London", 100, 10, 15);
        Ticket ticket2 = new Ticket("Paris", "New York", 200, 12, 18);
        Ticket ticket3 = new Ticket("Moscow", "Berlin", 150, 11, 16);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expectedTickets = {ticket3};
        Ticket[] actualTickets = aviaSouls.searchAndSortBy("Moscow", "Berlin", comparator);

        Assertions.assertArrayEquals(expectedTickets, actualTickets);
    }
}

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.Segment;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class DataForTests {
    public static final Segment segment1 = new Segment(LocalDateTime.of(21, Month.SEPTEMBER, 20,9, 0),
            LocalDateTime.of(21,Month.SEPTEMBER,20,11,0));

    public static final Segment segment2 = new Segment(LocalDateTime.of(21, Month.SEPTEMBER, 20,11, 30),
            LocalDateTime.of(21,Month.SEPTEMBER,20,12,10));

    public static final Segment segment3 = new Segment(LocalDateTime.of(21, Month.SEPTEMBER, 21,9, 0),
            LocalDateTime.of(21,Month.SEPTEMBER,20,10,0));

    public static final Segment segment4 = new Segment(LocalDateTime.of(21, Month.SEPTEMBER, 20,18, 0),
            LocalDateTime.of(21,Month.SEPTEMBER,20,19,40));

    //все перелеты соотвествауют фильтру, у которого исключены перелёты до текущего времени
    //нормальный двухчасовой перелёт
    public static final Flight flight1 = new Flight(List.of(segment1));

    //номальный мультисегментный перелёт
    public static final Flight flight2 = new Flight(List.of(segment1, segment2));

    //перелёт с вылетом позже, чем прибытие
    public static final Flight flight3 = new Flight(List.of(segment3));

    //общее время, проведённое на земле превышает два часа
    public static final Flight flight4 = new Flight(List.of(segment1,segment4));

    public static List<Flight> getList(){
        return List.of(flight1,flight2,flight3,flight4);
    }
}

package griffio.expenses;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class DateTest {

  @Test
  public void expenses_uses_ISO_8601_format() {

    String iso_date_fixture = "2014-08-01";
    LocalDate localDate = LocalDate.parse(iso_date_fixture);
    Assert.assertEquals(iso_date_fixture, localDate.toString());
  }

}

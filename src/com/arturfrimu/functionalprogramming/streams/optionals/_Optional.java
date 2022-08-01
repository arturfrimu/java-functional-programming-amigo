package com.arturfrimu.functionalprogramming.streams.optionals;

import javax.sql.rowset.serial.SerialStruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {
        Object optional1 = Optional.ofNullable(null).orElse("default value");
        System.out.println(optional1);

        List<String> list = null;

        Object optional2 = Optional.ofNullable(list).orElse(Collections.emptyList());
        System.out.println(optional2);

        String email1 = null;
        Optional.ofNullable(email1).ifPresentOrElse(e -> System.out.println("Sending email to " + e),
                () -> System.out.println("Cannot send email"));

        String email2 = "artur.frimu@gmail.com";
        Optional.ofNullable(email2).ifPresentOrElse(e -> System.out.println("Sending email to " + e),
                () -> System.out.println("Cannot send email"));
    }
}

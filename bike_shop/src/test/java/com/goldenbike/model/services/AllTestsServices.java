package com.goldenbike.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.goldenbike.model.services.bikeservice.BikeSvcImplTest;
import com.goldenbike.model.services.factory.ServiceFactoryTest;
import com.goldenbike.model.services.reservationservice.ReservationSvcImplTest;

@RunWith(Suite.class)
@SuiteClasses({BikeSvcImplTest.class, ServiceFactoryTest.class, ReservationSvcImplTest.class})
public class AllTestsServices {

}

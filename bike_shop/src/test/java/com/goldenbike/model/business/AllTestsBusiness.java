package com.goldenbike.model.business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.goldenbike.model.business.manager.BikeManagerTest;
import com.goldenbike.model.business.manager.ReservationManagerTest;

@RunWith(Suite.class)
@SuiteClasses({BikeManagerTest.class, ReservationManagerTest.class})
public class AllTestsBusiness {

}

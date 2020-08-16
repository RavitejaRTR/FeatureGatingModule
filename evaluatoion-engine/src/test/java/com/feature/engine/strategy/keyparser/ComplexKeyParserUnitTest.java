package com.feature.engine.strategy.keyparser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class ComplexKeyParserUnitTest {

    private static final String KEY = "address";

    @InjectMocks
    ComplexKeyParser complexKeyParser = new ComplexKeyParser();

    @Test
    public void testParseKey() throws NoSuchFieldException {
        Assert.assertEquals(10, complexKeyParser.parseKey("address.subGroup.num", getUserAttributes()));
    }

    private Map<String, Object> getUserAttributes() {
        SubGroup s = new SubGroup();
        s.setNum(10);
        Address a = new Address();
        a.setName("Lane1");
        a.setSubGroup(s);
        Map<String, Object> userAttr = new HashMap<>();
        userAttr.put(KEY, a);
        return userAttr;
    }

    class Address{
        public String name;

        public SubGroup subGroup;

        public SubGroup getSubGroup() {
            return subGroup;
        }

        public void setSubGroup(SubGroup subGroup) {
            this.subGroup = subGroup;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class SubGroup{
        public Integer num;

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }

}

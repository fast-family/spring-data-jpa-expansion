package com.zs.spring.data.jpa;


public enum  MatchMode {


    EXACT {
        @Override
        public String toMatchString(String paramString) {
            return paramString;
        }
    },
    START {
        @Override
        public String toMatchString(String paramString) {
            return "%" + paramString;
        }
    },
    END {
        @Override
        public String toMatchString(String paramString) {
            return paramString + "%";
        }
    },
    ANYWHERE {
        @Override
        public String toMatchString(String paramString) {
            return "%" + paramString + "%";
        }
    };

    MatchMode() {
    }

    public abstract String toMatchString(String paramString);
}

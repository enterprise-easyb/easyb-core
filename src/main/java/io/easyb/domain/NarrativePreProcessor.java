package io.easyb.domain;

import io.easyb.util.PreProcessorable;

public class NarrativePreProcessor implements PreProcessorable {
    public String process(String specification) {
        return specification
                .replaceAll("(\\{*\\s)[Aa]s a([^\\}]*\\})", "$1as_a$2")
                .replaceAll("(\\{*\\s)[Ii] want([^\\}]*\\})", "$1i_want$2")
                .replaceAll("(\\{*\\s)[Ss]o that([^\\}]*\\})", "$1so_that$2");
    }
}

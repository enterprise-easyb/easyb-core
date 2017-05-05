
Prism.languages.easyb = Prism.languages.extend('groovy', {
//    'easyb-keyword': /\b(it|description|narrative|scenario|given|when|then|and|but|using|ignore|where|examples|shared behavior|it behaves as|[Aa]s a|[Ii] want|[Ss]o that|[Ii]n order to)\b/
    'easyb-keyword': /\b(it|description|narrative|scenario|given|when|then|and|but|using|extension|ignore all|ignore|where|examples|shared behavior|[Ii] want|[Ss]o that|[Ii]n order to|fail)\b/,
    'easyb-fixture': {
        pattern: /\b(before|before_each|before each|after|after_each|after each)\b/,
        alias: 'easyb-keyword'
    },
    'easyb-should': {
        pattern: /\b(should(Be|Equal|BeEqual|BeEqualTo|NotBe|NotEqual|ntBe|ntEqual|BeA|BeAn|NotBeA|NotBeAn|BeGreaterThan|BeLessThan|StartWith|EndWith|Have|NotHave|BeA(?:\w+)?|NotBeA(?:\w+)?))\b/,
        alias: 'easyb-keyword'
    },
    'easyb-ensuredelegate': {
        pattern: /\b(isNull|isNotNull|isA(?:\w+)?|isEqual|isEqualTo(?:\w+)?|isNotEqualTo(?:\w+)?|isTrue|isFalse|contains|has)\b/,
        alias: 'easyb-keyword'
    },
    'easyb-deprecated': {
        pattern: /\b(before_each|after_each|shared_behavior|it_behaves_as|as_a|as_an|i_want|so_that)\b/,
        alias: 'easyb-keyword'
    }
});


// Define these before the standard keywords (inherited from groovy) so that groovy 'as' keyword doesn't get in the way

Prism.languages.insertBefore('easyb', 'keyword', {
    'easyb-as': {
        pattern: /\b(it behaves as|as a)\b/,
        alias: 'easyb-keyword'
    }
});


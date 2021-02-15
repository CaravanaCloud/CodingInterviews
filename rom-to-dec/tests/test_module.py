from romtodec import romanToInt

def test_1():
    assert romanToInt("I") == 1

def test_39():
    assert romanToInt("XXXIX") == 39

def test_4():
    assert romanToInt("IV") == 4

def test_6():
    assert romanToInt("VI") == 6

def test_499():
    assert romanToInt("CDXCIX") == 499

def test_3999():
    assert romanToInt("MMMCMXCIX") == 3999
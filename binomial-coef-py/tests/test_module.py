from bcoef import binomial

def test_A():
    assert binomial(4,2) == 6

def test_B():
    assert binomial(5,3) == 10

def test_C():
    assert binomial(20,10) == 184756


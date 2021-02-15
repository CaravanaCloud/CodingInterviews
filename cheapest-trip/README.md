https://twitter.com/adrianolcp/status/1360643595548688387

Você quer viajar de carro de s para t e já decidiu a rota: você vai seguir uma rodovia que passa
pelas cidades u1, U2,, un- Você sabe a distância entre duas cidades vizinhas em sua rota, e
sabe também que o tanque do seu carro permite que você viaje no máximo k quilômetros sem
reabastecer. Seu objetivo é gastar o menor valor possível em combustível durante a viagem.
Como o preço do combustível varia consideravelmente de uma cidade para outra, você
consultou online o preço do combustível na cidade ui, definido por Para simplificar,
assuma que os preços sao expressos em reais por quilômetro, ou seja, quanto custa para comprar
combustível suficiente para rodar por um quilômetro.

Assuma que você sai de S com o tanque cheio. Dados os preços p(ui) pesquisados, planeje
sua viagem de forma que você chegue a t gastando O mínimo possível em combustível.

a) Dado o exemplo ilustrado na tabela abaixo, e assumindo que um tanque cheio roda no
máximo 20 quilômetros, encontre o preço mínimo possível de gastos com combustível para
chegar de S a t.

Cidade
ui
u2
U3
us
us
us
u7
us
ug
t

Preço/p(24)
3
5
2
1
5
4
9
9
4
1

Distância
7
10
3
3
16
9
18
17
5
4

b) Descreva um algoritmo de programação dinâmica que resolva este problema. O algoritmo
deve ser polinomial em n e k. (Dica: expresse o preço do combustível para chegar a t
saindo de ui, usando uma quantidade de combustível c, como uma função de custo que
leva em conta o vértice uj, onde j>i.)
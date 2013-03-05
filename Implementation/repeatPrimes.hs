import Data.List
import Data.Numbers.Primes

--Output an Array with repeat numbers 

-- Generate [2,2,3,3,3,7,...,7,....] Sum : 2013
main = writeFile "repeatPrimes" $unlines.map show.(take 2013).repArray $take 1000 primes

repArray :: [Int] -> [Int]
repArray = concat.map (\x -> replicate x x)


import Data.List
import Data.Ratio 
import Text.Printf
import System.CPUTime

myInteger=map (toInteger)
--Count the percentage of primes ranged from 1 to 10^34


result = foldL $[toInteger 4] ++ (map(primesNumber) $func $myInteger $zipWith (^) [10,10..] [1..8])    

primesNumber :: (Integer, Integer) -> Integer
primesNumber (minNum, maxNum) = toInteger $length(takeWhile(<maxNum)$dropWhile(<minNum) primes)

func :: [Integer] -> [(Integer, Integer)]
func set = take (length(set) -1) $func' set set'
           where func' setA setB = [(head setA, head setB)]++func' (tail setA) (tail setB) 
                 set' = tail set ++ [last set]
                 
foldL :: [Integer]->[Integer]
foldL [] = []
foldL set = zipWith(+) set ([0]++(foldL set))
        
--          | numSet==[] = 0
--          | isPrime(head(numSet)) = 1+primeNumber(tail(numSet))


primes = myInteger [2,3]++(filter(isPrime)$(map toInteger)[5,7..])
  where isPrime :: Integer -> Bool
        isPrime num = isPrimeL num primes
          
isPrimeL :: Integer -> [Integer] -> Bool 
isPrimeL num numSet | numSet==[] = True
                    | mod num (head(numSet)) ==0 = False
                    | div num (head(numSet)) <(head numSet) = True
                    | otherwise = isPrimeL num (tail$numSet)

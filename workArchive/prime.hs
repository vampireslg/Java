import Data.List
import Data.Ratio 
--Count the percentage of primes ranged from 1 to 10^34
result= foldL $[4] ++ (map(primesNumber) $func $zipWith (^) [10,10..] [1..15])
  where primesNumber (minNum, maxNum) = length(takeWhile(<maxNum)$dropWhile(<minNum) primes)
        
func :: [Int] -> [(Int, Int)]
func set = take (length(set) -1) $func' set set'
           where func' setA setB = [(head setA, head setB)]++func' (tail setA) (tail setB) 
                 set' = tail set ++ [last set]
                 
foldL :: [Int]->[Int]
foldL [] = []
foldL set = zipWith(+) set ([0]++(foldL set))
        
--          | numSet==[] = 0
--          | isPrime(head(numSet)) = 1+primeNumber(tail(numSet))


primes = [2,3]++(filter(isPrime)[5,7..])
  where isPrime :: Int -> Bool
        isPrime num = isPrimeL num primes
          
isPrimeL :: Int -> [Int] -> Bool 
isPrimeL num numSet | numSet==[] = True
                    | mod num (head(numSet)) ==0 = False
                    | div num (head(numSet)) <(head numSet) = True
                    | otherwise = isPrimeL num (tail$numSet)

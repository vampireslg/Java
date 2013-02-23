--use Mod method to computer the number of primes 
--in some range
import System.CPUTime

main = do 
     let t1 = primesNum [1..100]
     let t2 =  primesNum [1..100000]
     let t3 =  primesNum [1..1000000000] 
     return t3

primesNum :: [Integer] -> Integer
primesNum [] = toInteger 0
primesNum xs		 | isPrime (head xs) = toInteger $1 +(primesNum $tail xs)
	  		 | otherwise = primesNum $tail xs

isPrime :: Integer -> Bool
isPrime num	   | num == 1 = False
		   | num == 2|| num == 3 = True
		   | mod' num (takeWhile(<sqrtnum) primes) == 0 = False
		   | otherwise = True   
		     where sqrtnum = toInteger (ceiling $sqrt(fromIntegral (num +1)) )
		     	   mod' x [] = 1
		     	   mod' x (y:ys)       | mod x y == 0 = 0 
			   	  	       | otherwise = mod' x ys
					   
primes = [2,3]++ filter(isPrime) [5,7..]
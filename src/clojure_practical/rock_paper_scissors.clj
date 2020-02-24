(ns clojure-practical.rock-paper-scissors)

;; returns "r" for rock, "p" for paper, "s" for scissors
;; returns nil on invalid input
(defn get-guess []
  ;; we must use println instead of print to immediately flush the buffer, apparently
  (println "Play your hand: (r)ock, (p)aper, (s)cissors")
  (let [guess (read-line)]
    (if (get {"r" true "p" true "s" true} guess) guess)))


;; returns 1 for player 1 wins, 2 for player 2 wins, and 0 for a tie
(defn winner [guess1 guess2]
  (let [guesses [guess1 guess2]]
    (cond
      (= guess1 guess2)     0
      (= guesses ["p" "r"]) 1
      (= guesses ["r" "p"]) 2
      (= guesses ["r" "s"]) 1
      (= guesses ["s" "r"]) 2
      (= guesses ["s" "p"]) 1
      (= guesses ["p" "s"]) 2)))


(defn play-hand []
  (let [computer-guess (rand-nth ["r" "p" "s"])
        player-guess   (get-guess)
        winner         (winner computer-guess player-guess)]
    (println "The computer guessed:" computer-guess)
    (println "You guessed:" player-guess)
    (cond
      (= player-guess nil) (println "Your entry was invalid.")
      (= winner 0)         (println "Game tied!")
      (= winner 1)         (println "Computer wins!")
      (= winner 2)         (println "Player wins!"))))


(loop []
  (play-hand)
  (recur))

(ns day1.solution
  (:require
    [clojure.string :as str]))

(def demo-input
  "1000
  2000
  3000

  4000

  5000
  6000

  7000
  8000
  9000

  10000")

(def lines
  (slurp "src/day1/input1.txt"))

(defn split-lines
  [input]
  (let [splits (str/split input #"\n\n *")]
    (for [x splits]
      (str/split x #"\n *"))))

(defn max-of-calories
  [x]
  (let [total-calories (for [splits (split-lines x)]
                         (reduce + (map read-string splits)))]
    (apply max total-calories)))

(defn max-3-of-calories
  [x]
  (let [total-calories (for [splits (split-lines x)]
                         (reduce + (map read-string splits)))]
    (let [sorted (sort total-calories)]
      (reduce + (take 3 (reverse sorted))))))

(comment
  ;a)
  (max-of-calories lines)
  ;b)
  (max-3-of-calories lines)
  )
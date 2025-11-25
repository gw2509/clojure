(ns matrix
  (:require [clojure.string :as str]))

(defn get-all-rows
  [matrix]
  (str/split matrix #"\n"))

(defn get-row
  "Returns the i-th row of the matrix."
  [matrix i]
  (let [rows (get-all-rows matrix)
        row (str/split (nth rows (dec i)) #" ")]
    (map parse-long row)))

(defn get-column
  "Returns the i-th column of the matrix."
  [matrix i]
  (let [rows (get-all-rows matrix)]
    (map (fn [row] (parse-long (nth (str/split row #" ") (dec i)))) rows)))


;; or


(defn parse [s]
  (map #(clojure.edn/read-string (str "[" % "]"))
       (clojure.string/split-lines s)))

(defn getter
  "Factory function - This is a higher-order function used
  to generate other functions (get-row or get-column).
  It abstracts the logic of parsing, processing, and indexing."
  [proc]
  (fn [s i] (nth (proc (parse s)) (dec i))))

(def get-row (getter identity))

(def get-column (getter (partial apply map list)))


;; This is a standard Clojure idiom for transposing a matrix
;; (partial apply map list)
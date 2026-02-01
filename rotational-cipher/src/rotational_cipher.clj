(ns rotational-cipher
  (:require [clojure.string :as s]))

(defn is-uppercase? [c]
  (let [i (int c)]
    (and (> i 64) (< i 91))))

(defn is-lowercase? [c]
  (let [i (int c)]
    (and (> i 96) (< i 123))))

(defn rotate-char [l n]
  (cond
    (is-lowercase? l) (let [new-char (+ 97 (mod (+ (- (int l) 97) n) 26))]
                        (char new-char))

    (is-uppercase? l) (let [new-char (+ 65 (mod (+ (- (int l) 65) n) 26))]
                        (char new-char))
    :else l))

(defn rotate [s n]
  (apply str (map #(rotate-char % n) (seq s))))


;; Much more idiomatic Clojure solution

(def ^:const alphabet "abcdefghijklmnopqrstuvwxyz")

(defn rotate [text key]
  (let [shifted (take 26 (drop (mod key 26) (cycle alphabet)))
        cipher (zipmap (str alphabet (s/upper-case alphabet))
                       (concat shifted (map s/upper-case shifted)))]
    (apply str (map #(cipher % %) text))))



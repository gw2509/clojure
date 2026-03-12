(ns atbash-cipher
  (:require [clojure.string :as str]))

(def ^:private cipher
  (let [letters "abcdefghijklmnopqrstuvwxyz"
        digits "0123456789"]
    (zipmap (concat letters digits)
            (concat (reverse letters) digits))))

(defn encode
  "Encodes text using the Atbash cipher."
  [plaintext]
  (->> (str/lower-case plaintext)
       (map cipher)
       (filter some?)
       (partition-all 5)
       (map str/join)
       (str/join " ")))

(defn decode
  "Decodes text using the Atbash cipher."
  [ciphertext]
  (str/join (map cipher ciphertext)))




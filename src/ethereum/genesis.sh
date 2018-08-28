#!/bin/bash
GEN_NONCE="0xeddeadbabeeddead"
GEN_CHAIN_ID=1981
GEN_ALLOC='"0x0000000000000000000000000000000000000001": {"balance": "100000"}, "0xf6165e3ab53a51e974af53b4af28e53f6dc405e2": {"balance": "100000"}'
sed "s/\${GEN_NONCE}/$GEN_NONCE/g" src/genesis.json.template | sed "s/\${GEN_ALLOC}/$GEN_ALLOC/g" | sed "s/\${GEN_CHAIN_ID}/$GEN_CHAIN_ID/g" > genesis.json
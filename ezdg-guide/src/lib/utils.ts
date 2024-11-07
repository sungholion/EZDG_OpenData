import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"
import { algoliasearch } from "algoliasearch"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export function createinstantSearchClient(appId: string, searchApiKey: string) {
  return algoliasearch(appId, searchApiKey)
}

import Link from "next/link";
import { Popover, PopoverContent, PopoverTrigger } from "@/components/ui/popover";
import { Button } from "@/components/ui/button";
import { DiscordLogoIcon } from "@radix-ui/react-icons";
import { GitlabIcon } from "lucide-react";

export function AppFooter() {
  return (
    <footer className="w-full bg-white border-t">
      <div className="container mx-auto">
        <div className="w-full max-w-screen-xl p-4 md:py-6 mx-auto">
          <div className="sm:flex sm:items-center sm:justify-between">
            <span className="block text-sm text-gray-500 sm:text-center">
              © {new Date().getFullYear()} EZDG™. All Rights Reserved.
            </span>
            <ul className="mb-6 flex flex-wrap items-center text-sm font-medium text-gray-500 sm:mb-0">
              <li>
                <Link href="/" className="mr-4 hover:underline md:mr-6">
                  Home
                </Link>
              </li>
              <li>
                <Link href="/privacy-policy" className="mr-4 hover:underline md:mr-6">
                  Privacy Policy
                </Link>
              </li>
              <li>
                <Popover>
                  <PopoverTrigger asChild>
                    <Button variant="link" className="text-sm font-medium text-gray-500 p-0">
                      Contact
                    </Button>
                  </PopoverTrigger>
                  <PopoverContent className="w-auto">
                    <div className="flex flex-col gap-2">
                      <a
                        href="https://discord.gg/YJXHzF8k"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="flex items-center gap-2 p-2 hover:bg-gray-100 rounded-md transition-colors">
                        <DiscordLogoIcon className="h-4 w-4" />
                        <span>Discord</span>
                      </a>
                      <a
                        href="https://lab.ssafy.com/s11-final/S11P31D201"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="flex items-center gap-2 p-2 hover:bg-gray-100 rounded-md transition-colors">
                        <GitlabIcon className="h-4 w-4" />
                        <span>GitLab</span>
                      </a>
                    </div>
                  </PopoverContent>
                </Popover>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  );
}

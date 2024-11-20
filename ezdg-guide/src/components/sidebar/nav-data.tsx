import { ChevronRight } from "lucide-react";
import Link from "next/link";
import { Collapsible, CollapsibleContent, CollapsibleTrigger } from "@/components/ui/collapsible";
import {
  SidebarGroup,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarMenuSub,
  SidebarMenuSubButton,
  SidebarMenuSubItem,
} from "@/components/ui/sidebar";
import { GuideMenuItem, isApiGuideItem } from "@/types/guide";
import { formatFieldName } from "@/lib/format";
import { useState, useMemo } from "react";

interface GuideMenuProps {
  items: GuideMenuItem[];
}

const getGroupKey = (item: GuideMenuItem) => {
  const title = isApiGuideItem(item) ? item.mainTitle : item.originalFileName;

  // 지역별 그룹화
  if (title.includes("대구")) return "대구광역시";
  if (title.includes("구미")) return "구미시";
  if (title.includes("부산")) return "부산광역시";

  // 주제별 그룹화 (API 항목)
  if (title.includes("기상청")) return "기상/날씨";
  if (title.includes("환경")) return "환경";
  if (title.includes("관광")) return "관광";
  if (title.includes("금융")) return "금융";
  if (title.includes("조달청")) return "조달";

  return "기타";
};

export function NavData({ items }: GuideMenuProps) {
  const [openStates, setOpenStates] = useState<Record<string, boolean>>({});
  const [openItemStates, setOpenItemStates] = useState<Record<string, boolean>>({});

  const toggleOpen = (itemId: string) => {
    setOpenStates((prev) => ({
      ...prev,
      [itemId]: !prev[itemId],
    }));
  };

  const toggleItemOpen = (itemId: string) => {
    setOpenItemStates((prev) => ({
      ...prev,
      [itemId]: !prev[itemId],
    }));
  };

  const groupedItems = useMemo(() => {
    const groups: Record<string, GuideMenuItem[]> = {};

    items.forEach((item) => {
      const groupKey = getGroupKey(item);
      if (!groups[groupKey]) {
        groups[groupKey] = [];
      }
      groups[groupKey].push(item);
    });

    // 그룹 정렬
    const orderedGroups: Record<string, GuideMenuItem[]> = {};
    ["대구광역시", "구미시", "부산광역시", "관광", "환경", "기상/날씨", "금융", "조달", "기타"].forEach((key) => {
      if (groups[key]) {
        orderedGroups[key] = groups[key];
      }
    });

    return orderedGroups;
  }, [items]);

  return (
    <SidebarGroup>
      <SidebarGroupLabel>Data</SidebarGroupLabel>
      <SidebarMenu>
        {Object.entries(groupedItems).map(([group, groupItems]) => (
          <SidebarMenuItem key={group}>
            <Collapsible
              asChild
              className="group/collapsible"
              open={openStates[group]}
              onOpenChange={() => toggleOpen(group)}>
              <>
                <CollapsibleTrigger asChild>
                  <SidebarMenuButton
                    tooltip={openStates[group] ? undefined : group}
                    className={openStates[group] ? "pb-2" : ""}>
                    <div className="flex items-center w-full">
                      <span className={`${openStates[group] ? "whitespace-normal leading-snug py-0.5" : "truncate"}`}>
                        {group}
                      </span>
                      <ChevronRight
                        className={`ml-auto flex-shrink-0 transition-transform duration-200 ${
                          openStates[group] ? "rotate-90" : ""
                        }`}
                      />
                    </div>
                  </SidebarMenuButton>
                </CollapsibleTrigger>
                <CollapsibleContent>
                  <SidebarMenuSub className="pt-1">
                    {groupItems.map((item) => (
                      <SidebarMenuSubItem key={item._id}>
                        {isApiGuideItem(item) ? (
                          <Collapsible
                            asChild
                            className="group/collapsible"
                            open={openItemStates[item._id]}
                            onOpenChange={() => toggleItemOpen(item._id)}>
                            <>
                              <CollapsibleTrigger asChild>
                                <SidebarMenuButton
                                  tooltip={openItemStates[item._id] ? undefined : item.mainTitle}
                                  className={openItemStates[item._id] ? "pb-2" : ""}>
                                  <div className="flex items-center w-full">
                                    <span className="truncate">{formatFieldName(item.mainTitle)}</span>
                                    <ChevronRight
                                      className={`ml-auto flex-shrink-0 transition-transform duration-200 ${
                                        openItemStates[item._id] ? "rotate-90" : ""
                                      }`}
                                    />
                                  </div>
                                </SidebarMenuButton>
                              </CollapsibleTrigger>
                              <CollapsibleContent>
                                <SidebarMenuSub className="pt-1">
                                  {item.apiList.map((api) => (
                                    <SidebarMenuSubItem key={api.className}>
                                      <SidebarMenuSubButton asChild>
                                        <Link
                                          href={`/datas/${item._id}/${api.className}`}
                                          onClick={(e) => e.stopPropagation()}
                                          className="w-full">
                                          <span className="block truncate" title={api.title}>
                                            {api.title}
                                          </span>
                                        </Link>
                                      </SidebarMenuSubButton>
                                    </SidebarMenuSubItem>
                                  ))}
                                </SidebarMenuSub>
                              </CollapsibleContent>
                            </>
                          </Collapsible>
                        ) : (
                          <SidebarMenuButton asChild>
                            <Link href={`/datas/${item._id}`} onClick={(e) => e.stopPropagation()} className="w-full">
                              <span className="truncate" title={item.originalFileName}>
                                {formatFieldName(item.originalFileName)}
                              </span>
                            </Link>
                          </SidebarMenuButton>
                        )}
                      </SidebarMenuSubItem>
                    ))}
                  </SidebarMenuSub>
                </CollapsibleContent>
              </>
            </Collapsible>
          </SidebarMenuItem>
        ))}
      </SidebarMenu>
    </SidebarGroup>
  );
}

export default NavData;
